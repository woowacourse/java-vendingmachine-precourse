package vendingmachine.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import vendingmachine.constant.ErrorConst;

public class ItemList {
	private final List<Item> items;

	public ItemList(List<Item> items) {
		checkDupName(items);
		this.items = items;
	}

	public int getLeastItemPrice() {
		List<Integer> priceList = items.stream().map(Item::getPrice).sorted().collect(Collectors.toList());
		return priceList.get(0);
	}

	private void checkDupName(List<Item> items) {
		List<String> nameList = new ArrayList<>();
		for (Item item : items) {
			if (nameList.contains(item.getName())) {
				throw new IllegalArgumentException(ErrorConst.DUP_ITEM_NAME);
			}
			nameList.add(item.getName());
		}
	}
}
