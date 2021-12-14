package vendingmachine.domain;

import java.util.ArrayList;
import java.util.List;

public class Items {
	private final List<Item> items;

	public Items() {
		this.items = new ArrayList<>();
	}

	public void addItem(Item item) {
		items.add(item);
	}

	public Item purchaseItem(String itemName) {
		Item item = findItem(itemName);
		item.reduceQuantity();
		return item;
	}

	public boolean isSoldOut(Item item) {
		return item.isZeroQuantity();
	}

	private Item findItem(String itemName) {
		for (Item item : items) {
			if (item.isEqualItemName(itemName)) {
				return item;
			}
		}
		return new Item("", 0, 0);
	}

	public int getMinItemPrice() {
		int minPrice = Integer.MAX_VALUE;
		for (Item item : items) {
			if (!item.isZeroQuantity()) {
				minPrice = Math.min(minPrice, item.getPrice());
			}
		}
		return minPrice;
	}

	public boolean hasNoStock() {
		for (Item item : items) {
			if (!item.isZeroQuantity()) {
				return false;
			}
		}
		return true;
	}

	public List<String> getItemList() {
		List<String> itemList = new ArrayList<>();
		for (Item item : items) {
			if (!isSoldOut(item)) {
				itemList.add(item.getItemName());
			}
		}
		return itemList;
	}
}
