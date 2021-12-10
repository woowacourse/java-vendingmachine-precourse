package vendingmachine.model;

import java.util.List;

import vendingmachine.resource.ItemStorage;

public class ItemModel {
	private final static ItemModel itemModel = new ItemModel();

	private ItemStorage itemStorage;

	private ItemModel() {
		itemStorage = ItemStorage.getItemStorage();
	}

	public static ItemModel getItemModel() {
		return itemModel;
	}

	public void createItems(List<String> itemList) {
		for (int i = 0; i < itemList.size() % 3; i++) {
			String name = itemList.get(i * 3);
			int price = Integer.parseInt(itemList.get(i * 3 + 1));
			int quantity = Integer.parseInt(itemList.get(i * 3 + 2));
			itemStorage.creatItem(name, price, quantity);
		}
	}
}
