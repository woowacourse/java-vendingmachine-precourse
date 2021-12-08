package vendingmachine.repository;

import java.util.ArrayList;
import java.util.List;

import vendingmachine.domain.Item;

public class ItemRepository {

	private static final List<Item> itemRepository = new ArrayList<>();

	public void save(Item item) {
		itemRepository.add(item);
	}
}
