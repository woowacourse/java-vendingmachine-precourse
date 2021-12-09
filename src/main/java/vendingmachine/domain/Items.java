package vendingmachine.domain;

import java.util.HashMap;

public class Items {
	private final HashMap<String, Item> itemMap;

	public Items() {
		this.itemMap = new HashMap<>();
	}

	public void addItem(String itemName, Item item) {
		itemMap.put(itemName, item);
	}

	public int getMinItemPrice() {
		return itemMap.values().stream().mapToInt(i -> i.getPrice()).min().getAsInt();
	}

	public boolean getItemSoldOut(String itemName) {
		if (itemMap.get(itemName).isSoldOut()) {
			return true;
		}
		return false;
	}

	public boolean getAllItemsSoldOut() {
		for (Item item : itemMap.values()) {
			if (!item.isSoldOut()) {
				return false;
			}
		}
		return true;
	}

	public void buyItem(String itemName) {
		Item item = itemMap.get(itemName);
		item.decreaseQuantity();
	}

	public int getItemPrice(String itemName) {
		return itemMap.get(itemName).getPrice();
	}

}
