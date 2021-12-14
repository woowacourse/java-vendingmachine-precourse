package vendingmachine.model;

import java.util.ArrayList;
import java.util.List;

import vendingmachine.view.Messages;

public class Items {
	private List<Item> itemList = new ArrayList<>();

	public Item hasItem(String itemName) {
		for (Item item : itemList) {
			if (item.hasStock(itemName)) {
				return item;
			}
		}
		throw new IllegalArgumentException(Messages.ERROR_NOT_IN_STOCK);
	}

	public void addItem(Item newItem) {
		if (isAlreadyInStock(newItem)) {
			throw new IllegalArgumentException(Messages.ERROR_ALREADY_IN_STOCK);
		}
		itemList.add(newItem);
	}

	private boolean isAlreadyInStock(Item newItem) {
		for (Item item : itemList) {
			if (item.sameName(newItem)) {
				return true;
			}
		}
		return false;
	}

	public int minPrice() {
		int minPrice = Integer.MAX_VALUE;
		for (Item item : itemList) {
			minPrice = item.isMinPrice(minPrice);
		}
		return minPrice;
	}

	public boolean allOutOfStock() {
		for (Item item : itemList) {
			if (!item.isOutOfStock()) {
				return false;
			}
		}
		return true;
	}

}
