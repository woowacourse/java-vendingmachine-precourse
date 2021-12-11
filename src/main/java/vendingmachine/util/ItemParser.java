package vendingmachine.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import vendingmachine.domain.Item;

public class ItemParser {
	private static final String OBJECT_SEPARATOR = ";";

	public static List<Item> parseList(String itemListStr) {
		List<String> itemStrs = Arrays.asList(itemListStr.split(OBJECT_SEPARATOR));
		List<Item> items = new ArrayList<>();
		itemStrs.forEach(itemStr -> {
			Item item = parse(itemStr);
			if(hasName(items, item.getName()))
				throw new IllegalArgumentException(SystemMessage.ERROR_ITEM_NAME_DUPLICATE);

			items.add(item);
		});

		return items;
	}

	private static Item parse(String itemStr) {
		return ItemValidator.validate(itemStr);
	}

	private static boolean hasName(List<Item> items, String itemName) {
		for(Item item : items) {
			if(item.getName().equals(itemName))
				return true;
		}

		return false;
	}
}
