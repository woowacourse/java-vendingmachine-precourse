package vendingmachine.model.item.service;

import java.util.Comparator;
import java.util.List;

import vendingmachine.model.item.domain.Item;
import vendingmachine.model.shared.Error;

/**
 * 자판기의 상품 재고를 관리하는 model class
 *
 * @author YJGwon
 * @version 1.1
 * @since 1.0
 */
public class ItemManager {
	private final List<Item> items;

	public ItemManager(List<Item> items) {
		this.items = items;
	}

	public int getMinPrice() {
		Item cheapestItem = items.stream()
			.min(Comparator.comparingInt(Item::getPrice)).get();
		return cheapestItem.getPrice();
	}

	public boolean hasItem(String name) {
		return items.stream().anyMatch(item -> item.isName(name));
	}

	public boolean isAllSoldOut() {
		return items.isEmpty();
	}

	public Item takeOne(String name) {
		validateBuyingItem(name);
		Item buyingItem = items.stream().filter(item -> item.isName(name)).findFirst().get();
		buyingItem.takeOne();
		if (buyingItem.isSoldOut()) {
			items.remove(buyingItem);
		}
		return buyingItem;
	}

	private void validateBuyingItem(String name) {
		if (hasItem(name)) {
			return;
		}
		throw new IllegalArgumentException(Error.NO_SUCH_ITEM.getMassage());
	}
}
