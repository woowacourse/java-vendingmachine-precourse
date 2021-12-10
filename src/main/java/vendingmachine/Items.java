package vendingmachine;

import java.util.ArrayList;
import java.util.List;

public class Items {
	private List<Item> itemList = new ArrayList<>();

	public static boolean isAddable(String itemsInput) {
		String[] itemToAdd = itemsInput.substring(1, itemsInput.length() - 1).split(",");
		return Item.validItemStatus(itemToAdd[0], Integer.parseInt(itemToAdd[1]), Integer.parseInt(itemToAdd[2]));
	}

	public static void main(String[] args) {
		String testStr1 = "[콜라,1000,20]";
		String testStr2 = "[사이다,2000,30]";
		Items items = new Items();
		items.addItem(testStr1);
		items.addItem(testStr2);
		System.out.println(items.showItems());
	}

	public Item hasItem(String itemName) {
		for (Item item : this.itemList) {
			if (itemName.equals(item.getName())) {
				return item;
			}
		}
		return null;
	}

	public void addItem(String itemString) {
		this.itemList.add(new Item(itemString));
	}

	public void add(Item item) {
		this.itemList.add(item);
	}

	public int minPrice() {
		int minPrice = Integer.MAX_VALUE;
		for (Item item : this.itemList) {
			if (minPrice > item.getPrice()) {
				minPrice = item.getPrice();
			}
		}
		return minPrice;
	}

	public boolean allOutOfStock() {
		for (Item item : this.itemList) {
			if (!item.isOutOfStock()) {
				return false;
			}
		}
		return true;
	}

	public String showItems() {
		String itemsStatus = "";
		for (Item item : this.itemList) {
			itemsStatus = itemsStatus.concat(item.getStatus());
			itemsStatus = itemsStatus.concat("\n");
		}
		return itemsStatus;
	}
}
