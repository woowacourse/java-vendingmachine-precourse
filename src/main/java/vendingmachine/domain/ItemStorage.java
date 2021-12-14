package vendingmachine.domain;

import java.util.HashMap;
import java.util.Map;

public class ItemStorage {
	private final Map<String, Item> items = new HashMap<>();

	public void addItems(Map<String, Item> items) {
		for (String itemName : items.keySet()) {
			Item item = items.get(itemName);
			this.items.put(itemName, item);
		}
	}

	public Item get(String itemName) {
		return items.get(itemName);
	}

	private int getMinPrice() {
		int itemMinPrice = Integer.MAX_VALUE;
		for (String itemName : items.keySet()) {
			Item item = items.get(itemName);
			if (!item.isSoldOut() && item.getPrice() < itemMinPrice) {
				itemMinPrice = item.getPrice();
			}
		}
		return itemMinPrice;
	}

	public void isNoItem(Item item) {
		if (item == null) {
			throw new IllegalArgumentException("[ERROR] 해당하는 상품이 없습니다.");
		}
	}

	public void checkInputCoinAmountByItem(Item item, int inputCoinAmount) {
		if (inputCoinAmount < item.getPrice()) {
			throw new IllegalArgumentException("[ERROR] 투입금액이 부족합니다.");
		}
	}

	public boolean checkInputCoinAmountByMinPrice(int inputCoinAmount) {
		return inputCoinAmount < getMinPrice();
	}

	public Boolean isAllItemSoldOut() {
		for (String itemName : items.keySet()) {
			if (!items.get(itemName).isSoldOut()) {
				return false;
			}
		}
		return true;
	}
}
