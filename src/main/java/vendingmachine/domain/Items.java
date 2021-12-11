package vendingmachine.domain;

import java.util.List;

public class Items {
	private List<Item> items;

	public Items(List<Item> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Items{" +
			"items=" + items +
			'}';
	}
}
