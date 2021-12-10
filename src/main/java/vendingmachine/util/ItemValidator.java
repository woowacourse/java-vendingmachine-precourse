package vendingmachine.util;

import java.util.Arrays;
import java.util.List;

import vendingmachine.domain.Item;

public class ItemValidator {
	private static final String OBJECT_WRAP_LEFT = "[";
	private static final String OBJECT_WRAP_RIGHT = "]";
	private static final String PARAMETER_SEPARATOR = ",";
	private static final int FIRST_INDEX = 0;
	private static final int INDEX_GAP = 1;
	private static final int PARAMETER_COUNT = 3;
	private static final int NAME_INDEX = 0;
	private static final int PRICE_INDEX = 1;
	private static final int AMOUNT_INDEX = 2;
	private static final int PRICE_MIN = 100;

	public static Item validate(String itemStr) {
		if (!isWrapped(itemStr))
			throw new IllegalArgumentException(SystemMessage.ERROR_IS_NOT_WRAPPED);
		String itemParameterStr = unwrap(itemStr);

		List<Object> itemParameters = parameterStringToList(itemParameterStr);

		return new Item((String)itemParameters.get(NAME_INDEX)
			, (Integer)itemParameters.get(PRICE_INDEX)
			, (Integer)itemParameters.get(AMOUNT_INDEX));
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

	private static List<Object> parameterStringToList(String parameterStr) {
		List<Object> result = Arrays.asList(parameterStr.split(PARAMETER_SEPARATOR));

		if (isRightParameterCount(result))
			throw new IllegalArgumentException(SystemMessage.ERROR_ITEM_DELIMITER);

		int price = Integer.parseInt((String)result.get(PRICE_INDEX));
		result.set(PRICE_INDEX, price);

		result.set(AMOUNT_INDEX, Integer.parseInt((String)result.get(AMOUNT_INDEX)));

		return result;
	}

	private static boolean isRightParameterCount(List<Object> parameters) {
		return parameters.size() != PARAMETER_COUNT;
	}

	private static int validatePrice(String priceStr) {
		if(!isInteger(priceStr))
			throw new IllegalArgumentException(SystemMessage.ERROR_PRICE_IS_NOT_INTEGER);
		int price = Integer.parseInt(priceStr);

		return price;
	}

	private static boolean isInteger(String numberStr) {
		try {
			Integer.parseInt(numberStr);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
