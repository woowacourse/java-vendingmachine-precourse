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

	private void checkDupName(List<Item> items) {
		List<String> nameList = new ArrayList<>();
		for (Item item : items) {
			if (nameList.contains(item.getName())) {
				throw new IllegalArgumentException(ErrorConst.DUP_ITEM_NAME);
			}
			nameList.add(item.getName());
		}
	}

	public boolean haveAffordableItem(int amount) {
		List<Item> affordableItems = items.stream()
			.filter(item -> item.getPrice() <= amount && item.isRemain())
			.collect(Collectors.toList());

		return !affordableItems.isEmpty();
	}

	public Item getItem(String itemName) {
		return items.stream().filter(item -> item.getName().equals(itemName))
			.findFirst().orElseThrow(() -> new IllegalArgumentException(ErrorConst.HAVE_NO_THIS_ITEM));
	}
}
