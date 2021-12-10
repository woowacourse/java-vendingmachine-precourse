package vendingmachine.repository;

import java.util.ArrayList;
import java.util.List;

import vendingmachine.domain.item.Item;
import vendingmachine.domain.item.ItemName;
import vendingmachine.exception.ItemNotFoundException;

public class ItemsRepository {
	private static final ItemsRepository instance = new ItemsRepository();
	private final List<Item> items = new ArrayList<>();

	private ItemsRepository() {
	}

	public static ItemsRepository getInstance() {
		return instance;
	}

	public void create(Item item) {
		items.add(item);
	}

	public void updateByItemName(ItemName itemName, Item newItem) {
		Item originalItem = findByItemName(itemName);
		int itemIndex = items.indexOf(originalItem);
		items.set(itemIndex, newItem);
	}

	public List<Item> findAll() {
		return items;
	}

	public Item findByItemName(ItemName itemName) {
		return items.stream()
			.filter(item -> item.getItemName().equals(itemName))
			.findFirst()
			.orElseThrow(ItemNotFoundException::new);
	}
}
