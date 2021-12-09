package vendingmachine;

import java.util.HashMap;
import java.util.Map;

/**
 * 값을 분석해서 Item 객체를 만드는 model class
 *
 * @author YJGwon
 * @version 1.0
 * @since 1.0
 */
public class ItemParser {
	private Validator validator;

	private static final String ITEM_SEPARATOR = ";";
	private static final String PROPERTY_SEPARATOR = ",";

	private static final int NAME_INDEX = 0;
	private static final int PRICE_INDEX = 1;
	private static final int COUNT_INDEX = 2;

	public ItemParser() {
		this.validator = new Validator();
	}

	public Map<String, Item> stringToItems(String string) {
		Map<String, Item> items = new HashMap<>();
		String[] stringItems = string.split(ITEM_SEPARATOR);
		for (String stringItem : stringItems) {
			String[] properties = removeSquareBracket(stringItem).split(PROPERTY_SEPARATOR);
			Item item = propertiesToItem(properties);
			items.put(validator.validateNewItemName(items, properties[NAME_INDEX]), item);
		}
		return items;
	}

	private Item propertiesToItem(String[] properties) {
		return new Item(validator.validateItemPrice(properties[PRICE_INDEX]),
			validator.validateItemCount(properties[COUNT_INDEX]));
	}

	private String removeSquareBracket(String stringItem) {
		return stringItem.substring((stringItem.indexOf('[') + 1), stringItem.indexOf(']'));
	}
}
