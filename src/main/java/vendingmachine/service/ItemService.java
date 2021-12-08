package vendingmachine.service;

import java.util.ArrayList;
import java.util.List;

import vendingmachine.domain.Item;

public class ItemService {

	private static final List<Item> itemRepository = new ArrayList<>();

	public void register(Item item) {
		itemRepository.add(item);
	}
}
