package vendingmachine.repository;

import vendingmachine.domain.items.Items;

public class ItemsRepository {
	private static ItemsRepository instance = new ItemsRepository();
	private Items items;

	private ItemsRepository() {
	}

	public static ItemsRepository getInstance() {
		return instance;
	}

	public void setItems(Items items) {
		this.items = items;
	}

	public Items findAll() {
		return items;
	}

}
