package vendingmachine.domain;

import java.util.Collections;
import java.util.List;

public class Items {
	private final List<Item> items;

	public Items(List<Item> items) {
		this.items = items;
	}

	public List<Item> getItems() {
		return Collections.unmodifiableList(items);
	}
}
