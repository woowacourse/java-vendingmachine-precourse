package vendingmachine.service;

import java.util.PriorityQueue;
import java.util.Queue;

import vendingmachine.domain.Item;

public class ItemService {

	private static final Queue<Item> itemRepository = new PriorityQueue<>();

	public void register(Item item) {
		itemRepository.add(item);
	}

	public boolean haveAnyItemToBuy(int money) {
		return itemRepository.stream()
			.filter(item -> item.isAvailableToBuy(money))
			.findFirst()
			.isPresent();
	}

	public Item findByName(String name) {
		return itemRepository.stream()
			.filter(item -> item.isName(name))
			.findFirst()
			.orElse(null);
	}
}
