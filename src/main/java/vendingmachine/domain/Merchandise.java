package vendingmachine.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import vendingmachine.Parser;

public class Merchandise {
	private List<Item> itemList = new ArrayList<>();

	public void add(String item) {
		itemList.add(Parser.parseToItem(item));
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
