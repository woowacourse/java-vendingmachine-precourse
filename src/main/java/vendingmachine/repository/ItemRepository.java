package vendingmachine.repository;

import java.util.HashMap;

import vendingmachine.domain.Item;

public class ItemRepository {
	private final HashMap<String, Item> itemMap;

	public ItemRepository() {
		this.itemMap = new HashMap<>();
	}

	public void addItem(String itemName, Item item) {
		itemMap.put(itemName, item);
	}

	public int getMinItemPrice() {
		return itemMap.values().stream().mapToInt(i -> i.getPrice()).min().getAsInt();
	}

	public boolean isItemSoldOut(String itemName) {
		if (itemMap.get(itemName).isSoldOut()) {
			return true;
		}
		return false;
	}

	public boolean isAllItemSoldOut() {
		for (Item item : itemMap.values()) {
			if (!item.isSoldOut()) {
				return false;
			}
		}
		return true;
	}

	public int buyItemAndGetPrice(String itemName) {
		Item item = itemMap.get(itemName);
		item.decreaseQuantity();
		return itemMap.get(itemName).getPrice();
	}

}
