package vendingmachine.service;

import vendingmachine.domain.item.Item;
import vendingmachine.domain.item.ItemName;
import vendingmachine.domain.item.ItemPrice;
import vendingmachine.domain.items.Items;
import vendingmachine.domain.userbalance.UserBalance;
import vendingmachine.repository.ItemsRepository;

public class ItemsService {
	private static ItemsService itemsService = new ItemsService();
	private final ItemsRepository itemsRepository = ItemsRepository.getInstance();

	private ItemsService() {
	}

	public static ItemsService getInstance() {
		return itemsService;
	}

	public void initItems(Items items) {
		itemsRepository.setItems(items);
	}

	public boolean checkSoldOut() {
		Items items = itemsRepository.findAll();
		return items.isAllSoldOut();
	}

	public ItemPrice getMinItemPrice() {
		Items items = itemsRepository.findAll();
		return items.getMinItemPrice();
	}

	public void buyItem(Item item, UserBalance userBalance) {
		Items items = itemsRepository.findAll().buyItem(item, userBalance);
		itemsRepository.setItems(items);
	}

	public Item findByItemName(ItemName itemName) {
		return itemsRepository.findByItemName(itemName);
	}
}
