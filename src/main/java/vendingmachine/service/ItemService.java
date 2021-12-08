package vendingmachine.service;

import java.util.PriorityQueue;
import java.util.Queue;

import vendingmachine.domain.Item;

public class ItemService {

	private static final Queue<Item> itemRepository = new PriorityQueue<>();

	public void register(Item item) {
		itemRepository.add(item);
	}

	public Queue<Item> findAll() {
		return itemRepository;
	}

	public int getMinPrice() {
		return itemRepository.peek().getPrice();
	}
}
