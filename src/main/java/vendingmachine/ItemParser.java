package vendingmachine;

import java.util.HashMap;
import java.util.Map;

/**
 * 값을 분석해서 Item 객체를 만드는 model class
 *
 * @author YJGwon
 * @version 1.2
 * @since 1.0
 */
public class ItemParser {
	private static final String ITEM_SEPARATOR = ";";

	public Map<String, Item> mapItemsFrom(String string) {
		Map<String, Item> items = new HashMap<>();
		String[] stringItems = string.split(ITEM_SEPARATOR);
		for (String stringItem : stringItems) {
			Item item = Item.from(stringItem);
			validateDuplicate(items, item);
			items.put(item.getName(), item);
		}
		return items;
	}

	private void validateDuplicate(Map<String, Item> items, Item item) {
		if (!items.containsKey(item.getName())) {
			return;
		}
		throw new IllegalArgumentException(Error.DUPLICATE_ITEM.getMassage());
	}
}
