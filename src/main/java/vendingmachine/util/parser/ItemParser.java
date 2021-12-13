package vendingmachine.util.parser;

import java.util.HashMap;
import java.util.Map;

import vendingmachine.domain.Item;
import vendingmachine.util.validator.ItemValidator;

public class ItemParser extends Parser {
	private static final String SEMI_COLON = ";";
	private static final String LEFT_BIG_BRACKET = "[";
	private static final String RIGHT_BIG_BRACKET = "]";
	private static final String COMMA = ",";
	private static final String EMPTY = "";

	public static Map<String, Item> getItems(String input) {
		ItemValidator.isRightItemInput(input);
		Map<String, Item> items = new HashMap<>();
		for (String item : input.split(SEMI_COLON)) {
			item = removeBigBracket(item);
			putItemInItems(items, item);
		}
		return items;
	}

	private static void putItemInItems(Map<String, Item> items, String item) {
		String[] itemInfos = item.split(COMMA);
		items.put(itemInfos[0],
			new Item(itemInfos[0], Integer.parseInt(itemInfos[1]), Integer.parseInt(itemInfos[2])));
	}

	public static String removeBigBracket(String item) {
		item = item.replace(LEFT_BIG_BRACKET, EMPTY);
		item = item.replace(RIGHT_BIG_BRACKET, EMPTY);
		return item;
	}
}
