package vendingmachine.domain.repository;

import java.util.ArrayList;
import java.util.List;

import vendingmachine.domain.Item;

public class ItemRepository {
	private final List<Item> items = new ArrayList<>();

	public void addItem(Item item) {
		items.add(item);
	}
}
