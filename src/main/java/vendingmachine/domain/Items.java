package vendingmachine.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Items {

	private List<Item> list;

	public Items() {
		list = new ArrayList<>();
	}

	public void insertItems(String itemList) {
		List<String> items = separateItems(itemList);
		for (String item : items) {
			String processedItem = processItem(item);
			list.add(createItem(processedItem));
		}
	}

	private List<String> separateItems(String itemList) {
		return Arrays.asList(itemList.split(";"));
	}

	private String processItem(String item) {
		return item.substring(1, item.length() - 1);
	}

	private Item createItem(String item) {
		String[] separateItem = item.split(",");
		return new Item(separateItem[0], Integer.parseInt(separateItem[1]), Integer.parseInt(separateItem[2]));
	}
}
