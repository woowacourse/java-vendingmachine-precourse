package vendingmachine.validator;

import vendingmachine.exception.ItemInputFormatException;
import vendingmachine.exception.SoldOutException;

public class ItemValidator extends Validator {
	private static final String ITEM_SPLIT_DELIMITER = ",";
	private static final int ITEM_SPLIT_COUNT = 3;

	private static final int MULTIPLE = 10;
	private static final int MIN_PRICE = 100;

	public static void validateItemInputFormat(String input) {
		if (input.split(ITEM_SPLIT_DELIMITER).length != ITEM_SPLIT_COUNT) {
			throw new ItemInputFormatException();
		}

		// TODO: 상수로 분리 필요
		if (!input.contains("[") || !input.contains("]")) {
			throw new ItemInputFormatException();
		}
	}

	public static void validateItemName(String name) {
		validateNotBlank(name);
	}

	public static void validateItemPrice(String price) {
		validateNumeric(price);

		int parsedNumber = Integer.parseInt(price);
		validateNaturalNumber(parsedNumber);
		validateMultiple(parsedNumber, MULTIPLE);
		validateGreaterThanOrEqual(parsedNumber, MIN_PRICE);
	}

	public static void validateItemAmount(String price) {
		validateNumeric(price);

		int parsedNumber = Integer.parseInt(price);
		validateNaturalNumber(parsedNumber);
	}

	public static void validateAbleToSubtractItemAmount(int itemAmount) {
		if (itemAmount <= 0) {
			throw new SoldOutException();
		}
	}
}
