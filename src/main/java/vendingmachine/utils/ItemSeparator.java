package vendingmachine.utils;

import static vendingmachine.utils.Constant.*;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import vendingmachine.domain.Item;

public class ItemSeparator {

	public static List<Item> separateItems(String itemsString) {
		List<Item> items = new ArrayList<>();
		StringTokenizer stringTokenizer = new StringTokenizer(itemsString, ITEMS_DELIMITER);

		while (stringTokenizer.hasMoreTokens()) {
			String itemValue = stringTokenizer.nextToken();
			itemValue = itemValue.replaceAll(START_BRACKET, "").replaceAll(END_BRACKET, "");
			Item item = separateToItem(itemValue);
			items.add(item);
		}

		return items;
	}

	private static Item separateToItem(String itemValue) {
		StringTokenizer stringTokenizer = new StringTokenizer(itemValue, ITEM_DELIMITER);

		String itemName = stringTokenizer.nextToken().trim();
		int price = Integer.parseInt(stringTokenizer.nextToken().trim());
		int quantity = Integer.parseInt(stringTokenizer.nextToken().trim());

		return new Item(itemName, price, quantity);
	}
}
