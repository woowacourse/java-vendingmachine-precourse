package vendingmachine.model.item.service;

import java.util.ArrayList;
import java.util.List;

import vendingmachine.model.item.domain.Item;
import vendingmachine.model.shared.Error;

/**
 * 값을 분석해서 Item 객체를 만드는 model class
 *
 * @author YJGwon
 * @version 1.2
 * @since 1.0
 */
public class ItemParser {
	private static final String ITEM_SEPARATOR = ";";

	public List<Item> listFrom(String string) {
		List<Item> items = new ArrayList<>();
		String[] stringItems = string.split(ITEM_SEPARATOR);
		for (String stringItem : stringItems) {
			Item item = Item.from(stringItem);
			validateDuplicate(items, item);
			items.add(item);
		}
		return items;
	}

	private void validateDuplicate(List<Item> items, Item item) {
		if (items.stream().anyMatch(existingItem -> existingItem.hasSameNameWith(item))) {
			throw new IllegalArgumentException(Error.DUPLICATE_ITEM.getMassage());
		}
	}
}
