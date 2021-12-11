package vendingmachine.domain;

import java.util.List;

public class Items {
	private List<Item> items;

	public Items(List<Item> items) {
		this.items = items;
	}

	public int getMinPrice() {
		int minPrice = Integer.MAX_VALUE;
		for (Item item : items) {
			if (item.getQuantity() != 0) {
				minPrice = Math.min(minPrice, item.getPrice());
			}
		}
		return minPrice;
	}

	public boolean isStockEmpty() {
		for (Item item : items) {
			if (item.getQuantity() != 0) {
				return false;
			}
		}
		return true;
	}

	public boolean contains(String itemName) {
		for (Item item : items) {
			if (item.getItemName().equals(itemName)) {
				return true;
			}
		}
		return false;
	}

	public int getQuantity(String itemName) {
		for (Item item : items) {
			if (item.getItemName().equals(itemName)) {
				return item.getQuantity();
			}
		}
		return -1;
	}

	public int getPrice(String itemName) {
		for (Item item : items) {
			if (item.getItemName().equals(itemName)) {
				return item.getPrice();
			}
		}
		return -1;
	}

	@Override
	public String toString() {
		return "Items{" +
			"items=" + items +
			'}';
	}

	public void sell(String buyItem) {
		for (Item item : items) {
			if (item.getItemName().equals(buyItem)) {
				item.sellItem();
			}
		}
	}
}
