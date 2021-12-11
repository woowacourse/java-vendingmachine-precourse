package vendingmachine.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import vendingmachine.domain.Item;

public class ItemSeparator {
	public static final String ITEMS_DELIMITER = ";";
	public static final String ITEM_DELIMITER = ",";

	public static List<Item> separateItems(String itemsString) {
		List<Item> items = new ArrayList<>();
		StringTokenizer stringTokenizer = new StringTokenizer(itemsString, ITEMS_DELIMITER);
		while (stringTokenizer.hasMoreTokens()) {
			String itemValue = stringTokenizer.nextToken();
			itemValue = itemValue.replaceAll("\\[", "").replaceAll("\\]", "");
			Item item = separateItem(itemValue);
			items.add(item);
		}
		return items;
	}

	private static Item separateItem(String itemValue) {
		StringTokenizer stringTokenizer = new StringTokenizer(itemValue, ITEM_DELIMITER);
		String itemName = stringTokenizer.nextToken();
		int price = Integer.parseInt(stringTokenizer.nextToken());
		int quantity = Integer.parseInt(stringTokenizer.nextToken());
		return new Item(itemName, price, quantity);
	}
}
