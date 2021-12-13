package vendingmachine;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * 값을 분석해서 Item 객체를 만드는 model class
 *
 * @author YJGwon
 * @version 1.1
 * @since 1.0
 */
public class ItemParser {
	// 정규식으로 더 자세한 검증을 할 수도 있지만, 사용자에게 각각의 예외 경우에 대한 자세한 안내를 주기 위해 최소한의 형식만 검사
	// 상품명 공백, 가격과 수량 범위까지 검사하는 정규식 : "^\\[\\S+,[1-9][0-9]{3,},[1-9][0-9]*]$"
	private static final String ITEM_REGEX = "^\\[\\S+,[0-9]+,[0-9]+]$";

	private static final String ITEM_SEPARATOR = ";";
	private static final String PROPERTY_SEPARATOR = ",";

	private static final int NAME_INDEX = 0;
	private static final int PRICE_INDEX = 1;
	private static final int COUNT_INDEX = 2;

	private final Validator validator;

	public ItemParser() {
		this.validator = new Validator();
	}

	public Map<String, Item> stringToItems(String string) {
		Map<String, Item> items = new HashMap<>();
		String[] stringItems = string.split(ITEM_SEPARATOR);
		for (String stringItem : stringItems) {
			validateItemFormat(stringItem);
			String[] properties = removeSquareBracket(stringItem).split(PROPERTY_SEPARATOR);
			Item item = propertiesToItem(properties);
			items.put(validateNewItemName(items, properties[NAME_INDEX]), item);
		}
		return items;
	}

	private Item propertiesToItem(String[] properties) {
		return new Item(validator.stringToInteger(properties[PRICE_INDEX]),
			validator.stringToInteger(properties[COUNT_INDEX]));
	}

	private String removeSquareBracket(String stringItem) {
		return stringItem.substring((stringItem.indexOf('[') + 1), stringItem.indexOf(']'));
	}

	private void validateItemFormat(String input) {
		if (Pattern.matches(ITEM_REGEX, input)) {
			return;
		}
		throw new IllegalArgumentException(Error.ITEM_FORMAT.getMassage());
	}

	private String validateNewItemName(Map<String, Item> items, String name) {
		if (!validator.isBlank(name)) {
			throw new IllegalArgumentException(Error.BLANK.getMassage());
		}
		checkDuplicateItemName(items, name);
		return name;
	}

	private void checkDuplicateItemName(Map<String, Item> items, String name) {
		if (items.containsKey(name)) {
			throw new IllegalArgumentException(Error.DUPLICATE_ITEM.getMassage());
		}
	}
}
