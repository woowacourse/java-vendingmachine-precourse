package vendingmachine.domain.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import vendingmachine.domain.Item;
import vendingmachine.util.PublicConst;

public class ItemRepository {
	private final List<Item> items = new ArrayList<>();

	public void addItem(Item item) {
		items.add(item);
	}

	public Item getItemByName(String itemName) {
		try {
			return items.stream()
				.filter(item -> item.getName().equals(itemName))
				.collect(Collectors.toList())
				.get(PublicConst.FIRST_INDEX);
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}
}
