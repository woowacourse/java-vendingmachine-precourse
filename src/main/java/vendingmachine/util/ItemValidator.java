package vendingmachine.util;

import java.util.Arrays;
import java.util.List;

import vendingmachine.domain.Item;

public class ItemValidator {
	private static final int PARAMETER_COUNT = 3;
	private static final int NAME_INDEX = 0;
	private static final int PRICE_INDEX = 1;
	private static final int AMOUNT_INDEX = 2;
	private static final int PRICE_MIN = 100;

	public static Item validate(String itemStr) {
		if (!isWrapped(itemStr))
			throw new IllegalArgumentException(SystemMessage.ERROR_IS_NOT_WRAPPED);
		String itemParameterStr = unwrap(itemStr);

		List<String> itemParameters = parameterStringToList(itemParameterStr);

		return new Item(itemParameters.get(NAME_INDEX),
			Integer.parseInt(itemParameters.get(PRICE_INDEX)),
			Integer.parseInt(itemParameters.get(AMOUNT_INDEX)));
	}

	private static boolean isWrapped(String itemStr) {
		return PublicConst.ITEM_WRAP_LEFT
			.equals(Character.toString(itemStr.charAt(PublicConst.FIRST_INDEX)))
			&& PublicConst.ITEM_WRAP_RIGHT
			.equals(Character.toString(itemStr.charAt(itemStr.length() - PublicConst.INDEX_GAP)));
	}

	private static String unwrap(String itemStr) {
		return itemStr.substring(PublicConst.FIRST_INDEX + PublicConst.INDEX_GAP,
			itemStr.length() - PublicConst.INDEX_GAP);
	}

	private static List<String> parameterStringToList(String parameterStr) {
		List<String> result = Arrays.asList(parameterStr.split(PublicConst.ITEM_PARAMETER_SEPARATOR));

		if (isRightParameterCount(result))
			throw new IllegalArgumentException(SystemMessage.ERROR_ITEM_DELIMITER);

		validatePrice(result.get(PRICE_INDEX));
		validateAmount(result.get(AMOUNT_INDEX));

		return result;
	}

	private static boolean isRightParameterCount(List<String> parameters) {
		return parameters.size() != PARAMETER_COUNT;
	}

	private static void validatePrice(String priceStr) {
		if (isNotInteger(priceStr))
			throw new IllegalArgumentException(SystemMessage.ERROR_PRICE_IS_NOT_INTEGER);
		int price = Integer.parseInt(priceStr);

		if (!isMoreThanMin(price))
			throw new IllegalArgumentException(SystemMessage.ERROR_PRICE_MIN);

		if (!isMultipleOf10(price))
			throw new IllegalArgumentException(SystemMessage.ERROR_PRICE_IS_NOT_MULTIPLE_OF_10);
	}

	private static boolean isNotInteger(String numberStr) {
		try {
			Integer.parseInt(numberStr);
		} catch (Exception e) {
			return true;
		}
		return false;
	}

	private static boolean isMoreThanMin(int number) {
		return number >= PRICE_MIN;
	}

	private static boolean isMultipleOf10(int number) {
		return number % 10 == 0;
	}

	private static void validateAmount(String amountStr) {
		if (isNotInteger(amountStr))
			throw new IllegalArgumentException(SystemMessage.ERROR_AMOUNT_IS_NOT_INTEGER);
		int amount = Integer.parseInt(amountStr);

		if (!isPositive(amount))
			throw new IllegalArgumentException(SystemMessage.ERROR_AMOUNT_IS_NOT_POSITIVE);
	}

	private static boolean isPositive(int number) {
		return number > 0;
	}
}
