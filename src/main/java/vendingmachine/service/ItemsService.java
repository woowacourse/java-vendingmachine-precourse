package vendingmachine.service;

import vendingmachine.domain.Items.Items;
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
}
