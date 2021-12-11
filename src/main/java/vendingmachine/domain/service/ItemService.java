package vendingmachine.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import vendingmachine.domain.Item;
import vendingmachine.domain.repository.ItemRepository;

public class ItemService {
	private final ItemRepository itemRepository = new ItemRepository();

	public void addItems(List<Item> items) {
		items.forEach(itemRepository::addItem);
	}

	public Item searchItem(String itemName) {
		return itemRepository.getItemByName(itemName);
	}

	public void deductItemAmount(String itemName) {
		itemRepository.deductItemAmount(itemName);
	}

	public boolean canPurchaseByMoney(int money) {
		List<Item> purchasableItems = itemRepository.getAll()
			.stream()
			.filter(item -> item.getPrice() <= money)
			.collect(Collectors.toList());

		return !purchasableItems.isEmpty();
	}
}
