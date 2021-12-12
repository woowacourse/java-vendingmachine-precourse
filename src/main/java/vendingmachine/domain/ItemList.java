package vendingmachine.domain;

import java.util.ArrayList;
import java.util.List;

import vendingmachine.constant.ErrorConst;

public class ItemList {
	private List<Item> items = new ArrayList<>();

	public ItemList(List<Item> items) {
		checkDupName(items);
		this.items = items;
	}

	private void checkDupName(List<Item> items) {
		List<String> nameList = new ArrayList<>();
		for (Item item : items) {
			if(nameList.contains(item.getName())){
				throw new IllegalArgumentException(ErrorConst.DUP_ITEM_NAME);
			}
			nameList.add(item.getName());
		}
	}
}
