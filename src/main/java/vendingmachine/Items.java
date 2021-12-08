package vendingmachine;

import java.util.List;

public class Items {
	private List<Item> items;

	public void add(Item item) {
		this.items.add(item);
	}

	public int minPrice() {
		int minPrice = 0;
		for (Item item : this.items) {
			if (minPrice > item.getPrice()) {
				minPrice = item.getPrice();
			}
		}
		return minPrice;
	}

	public boolean allOutOfStock() {
		for (Item item : this.items) {
			if(!item.isOutOfStock()) {
				return false;
			}
		}
		return true;
	}
}
