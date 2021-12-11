package vendingmachine.validator;

import java.util.Arrays;
import java.util.regex.Pattern;

import vendingmachine.exception.DataDuplicatedException;
import vendingmachine.exception.ItemInputFormatException;
import vendingmachine.exception.SoldOutException;

public class ItemValidator extends Validator {
	private static final String ITEMS_DELIMITER = ";";
	private static final String ITEM_DELIMITER = ",";
	private static final String ITEM_FORMAT_REGEX_PATTERN = "\\[[a-zA-Z가-힣ㄱ-ㅎㅏ-ㅣ0-9]+,[0-9]+,[0-9]+]";

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

	public static void validateItemInputFormat(String itemInput) {
		boolean isFormatValid = Pattern.matches(ITEM_FORMAT_REGEX_PATTERN, itemInput);

		if (!isFormatValid) {
			throw new ItemInputFormatException();
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
