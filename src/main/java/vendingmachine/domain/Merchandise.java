package vendingmachine.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Merchandise {
	public static final int MERCHANDISE_NAME_INDEX = 0;
	public static final int MERCHANDISE_PRICE_INDEX = 1;
	public static final int MERCHANDISE_COUNT_INDEX = 2;
	private List<Item> itemList = new ArrayList<>();

	public void addItem(String item) {
		item = item.replace("[", "").replace("]", "");
		String[] elements = item.split(",");
		String name = elements[MERCHANDISE_NAME_INDEX];
		int price = Integer.parseInt(elements[MERCHANDISE_PRICE_INDEX]);
		int count = Integer.parseInt(elements[MERCHANDISE_COUNT_INDEX]);
		itemList.add(new Item(name, price, count));
	}

	public boolean isExistItem(String name) {
		for (Item item : itemList) {
			if (item.isSameItem(name)) {
				return true;
			}
		}
		return false;
	}

	public Item findItem(String name) {
		return itemList.stream()
			.filter(item -> item.isSameItem(name))
			.findAny()
			.orElse(null);
	}

	public boolean isAllSoldOut() {
		for (Item item : itemList) {
			if (item.isSoldOut() == false) {
				return false;
			}
		}
		return true;
	}

	public Item getLowPriceItemAmongRemainingItems() {
		Collections.sort(itemList);
		for (Item item : itemList) {
			if (item.isSoldOut() == false) {
				return item;
			}
		}
		return null;
	}
}
