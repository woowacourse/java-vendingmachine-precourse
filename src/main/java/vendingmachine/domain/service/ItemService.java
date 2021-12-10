package vendingmachine.domain.service;

import java.util.List;

import vendingmachine.domain.Item;
import vendingmachine.domain.repository.ItemRepository;

public class ItemService {
	private final ItemRepository itemRepository = new ItemRepository();

	public void addItems(List<Item> items) {
		items.forEach(itemRepository::addItem);
	}
}
