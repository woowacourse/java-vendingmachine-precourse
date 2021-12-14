package vendingmachine.utils;

import vendingmachine.domain.Item;
import vendingmachine.domain.Items;

public class BuyingItemValidation {
	public static void validateBuyingItem(Items items, int insertAmount, String buyingItem) {
		Item item = validateBuyingItemExist(items, buyingItem);
		validateBuyableItem(item);
		validateInsertAmountBiggerThanBuyingItem(item, insertAmount);
	}

	private static void validateInsertAmountBiggerThanBuyingItem(Item item, int insertAmount) {
		if (!item.isBuyable(insertAmount)) {
			throw new IllegalArgumentException("해당 상품이 잔액보다 비쌉니다.");
		}
	}

	private static void validateBuyableItem(Item item) {
		if (item.isAmountZero()) {
			throw new IllegalArgumentException("해당 상품의 재고가 없습니다.");
		}
	}

	private static Item validateBuyingItemExist(Items items, String buyingItem) {
		if (!items.isMatchingInItems(buyingItem)) {
			throw new IllegalArgumentException("존재하지 않는 상품명입니다.");
		}
		return items.findItemWithName(buyingItem);
	}
}
