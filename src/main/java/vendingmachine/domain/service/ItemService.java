package vendingmachine.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import vendingmachine.domain.Item;
import vendingmachine.domain.repository.ItemRepository;
import vendingmachine.util.SystemMessage;

public class ItemService {
	private final ItemRepository itemRepository = new ItemRepository();

	public void addItems(List<Item> items) {
		items.forEach(itemRepository::addItem);
	}

	public Item searchItem(String itemName) {
		Item item = itemRepository.getItemByName(itemName);
		if (item == null) {
			throw new IllegalArgumentException(SystemMessage.ERROR_NOT_EXIST_ITEM);
		}
		if (!item.isInStock())
			throw new IllegalArgumentException(SystemMessage.ERROR_IS_NOT_IN_STOCK);

		return item;
	}

	public void deductItemAmount(String itemName) {
		itemRepository.deductItemAmount(itemName);
	}

	public boolean canPurchaseByMoney(int money) {
		List<Item> purchasableItems = itemRepository.getAll()
			.stream()
			.filter(item -> item.canPurchase(money))
			.collect(Collectors.toList());

		return !purchasableItems.isEmpty();
	}
}
