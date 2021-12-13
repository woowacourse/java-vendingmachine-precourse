package vendingmachine.domain;

import java.util.List;
import java.util.Objects;

public class Items {
	private final List<Item> items;

	public Items(List<Item> items) {
		this.items = items;
	}

	public void addItem(Item item) {
		items.add(item);
	}

	public void purchaseItem(String itemName) {
		Objects.requireNonNull(findItem(itemName)).reduceQuantity();
	}

	public boolean isSoldOut(String itemName) {
		return Objects.requireNonNull(findItem(itemName)).isZeroQuantity();
	}

	private Item findItem(String itemName) {
		for (Item item : items) {
			if (item.isEqualItemName(itemName)) {
				return item;
			}
		}
		return null;
	}
}
