package vendingmachine.resource;

import java.util.List;

public class ItemStorage {
	private static final ItemStorage itemStorage = new ItemStorage();

	private List<Item> itemList;

	private ItemStorage() {
	}

	public static ItemStorage getItemStorage() {
		return itemStorage;
	}

	public void creatItem(String name, int price, int quantity) {
		itemList.add(new Item(name, price, quantity));
	}
}
