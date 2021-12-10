package vendingmachine.util;

import vendingmachine.domain.Item;

public class ItemValidator {
	private static final String OBJECT_WRAP_LEFT = "[";
	private static final String OBJECT_WRAP_RIGHT = "]";
	private static final int FIRST_INDEX = 0;
	private static final int INDEX_GAP = 1;

	public static Item validate(String itemStr) {
		if(!isWrapped(itemStr))
			throw new IllegalArgumentException(SystemMessage.ERROR_IS_NOT_WRAPPED);

		itemStr = unwrap(itemStr);

		return null;
	}

	private static boolean isWrapped(String itemStr) {
		return OBJECT_WRAP_LEFT
			.equals(Character.toString(itemStr.charAt(FIRST_INDEX)))
			&& OBJECT_WRAP_RIGHT
			.equals(Character.toString(itemStr.charAt(itemStr.length() - INDEX_GAP)));
	}

	private static String unwrap(String itemStr) {
		return itemStr.substring(FIRST_INDEX + INDEX_GAP, itemStr.length() - INDEX_GAP);
	}
}
