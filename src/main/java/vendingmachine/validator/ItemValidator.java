package vendingmachine.validator;

import java.util.Arrays;

import vendingmachine.exception.DataDuplicatedException;
import vendingmachine.exception.SoldOutException;

public class ItemValidator extends Validator {
	private static final String ITEMS_DELIMITER = ";";
	private static final String ITEM_DELIMITER = ",";

	private static final int MULTIPLE = 10;
	private static final int MIN_PRICE = 100;

	public static void validateItemsDuplication(String input) {
		int originalCount = input.split(ITEMS_DELIMITER).length;
		boolean duplicated = Arrays.stream(input.split(ITEMS_DELIMITER))
			.map(item -> item.split(ITEM_DELIMITER)[0])
			.distinct()
			.count() != originalCount;

		if (duplicated) {
			throw new DataDuplicatedException();
		}
	}

	public static void validateItemName(String name) {
		validateNotBlank(name);
	}

	public static void validateItemPrice(int price) {
		validateNaturalNumber(price);
		validateMultiple(price, MULTIPLE);
		validateGreaterThanOrEqual(price, MIN_PRICE);
	}

	public static void validateItemQuantity(int price) {
		validateNaturalNumber(price);
	}

	public static void validateAbleToSubtractItemQuantity(int itemQuantity) {
		if (itemQuantity <= 0) {
			throw new SoldOutException();
		}
	}
}
