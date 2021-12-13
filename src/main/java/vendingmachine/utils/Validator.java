package vendingmachine.utils;

import static vendingmachine.constants.Constant.*;
import static vendingmachine.constants.Message.*;

import java.util.List;
import java.util.regex.Pattern;

import vendingmachine.domain.Item;

public class Validator {
	private Validator() {

	}

	public static void validatePossession(String possession) {
		validateNumber(possession);
		validateUnit(possession);
	}

	public static Item validateItemInfo(String[] info, List<Item> registeredItems) {
		String name = validateName(info[0], registeredItems);
		int price = validatePrice(info[1]);
		int stock = validateStock(info[2]);

		return new Item(name, price, stock);
	}

	public static void validateItemInfoFormat(String itemInfo) {
		boolean isValidFormat = Pattern.matches(VALIDATE_ITEM_INFO_FORMAT, itemInfo);

		if (!isValidFormat) {
			throw new IllegalArgumentException(ERROR_INVALID_ITEM_FORMAT);
		}
	}

	public static void validateNumber(String input) {
		if (isBlanked(input)) {
			throw new IllegalArgumentException(ERROR_EMPTY_INPUT);
		} else if (!isNumber(input)) {
			throw new IllegalArgumentException(ERROR_IS_NOT_NUMBER);
		}
		checkIntegerRange(input);
	}

	private static void checkIntegerRange(String number) {
		try {
			Integer.parseInt(number);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ERROR_IS_NOT_INTEGER);
		}
	}

	public static void validateUnit(String input) {
		if (!isValidUnit(input)) {
			throw new IllegalArgumentException(ERROR_INVALID_INPUT_UNIT);
		}
	}

	public static int validatePrice(String price) {
		validateNumber(price);
		validateUnit(price);

		int validRangePrice = Parser.makeInteger(price);
		if (!isValidRange(validRangePrice)) {
			throw new IllegalArgumentException(ERROR_INVALID_ADD_ITEM_PRICE);
		}

		return validRangePrice;
	}

	public static int validateStock(String stock) {
		validateNumber(stock);

		int validRangeStock = Parser.makeInteger(stock);
		if (!isValidRange(validRangeStock)) {
			throw new IllegalArgumentException(ERROR_INVALID_ADD_ITEM_STOCK);
		}

		return validRangeStock;
	}

	private static boolean isValidRange(int number) {
		return number > MIN_RANGE_VALUE;
	}

	public static String validateName(String registerName, List<Item> others) {
		if (isBlanked(registerName)) {
			throw new IllegalArgumentException(ERROR_EMPTY_INPUT);
		} else if (isDuplicatedName(registerName, others)) {
			throw new IllegalArgumentException(ERROR_IS_DUPLICATED_ITEM_NAME);
		}

		return registerName;
	}

	public static void validateAddingItemFormat(String addingItemInputLine) {
		if (isLastIndexSemiColon(addingItemInputLine)) {
			throw new IllegalArgumentException(ERROR_INVALID_ITEM_ADDING_FORMAT);
		}
	}

	public static void validatePurchaseItemName(String name, List<Item> forSaleList) {
		if (isBlanked(name)) {
			throw new IllegalArgumentException(ERROR_EMPTY_INPUT);
		} else if (!isDuplicatedName(name, forSaleList)) {
			throw new IllegalArgumentException(ERROR_INVALID_ITEM_NAME);
		}
	}

	private static boolean isDuplicatedName(String registerName, List<Item> otherItems) {
		return otherItems.stream().anyMatch(i -> i.getName().equals(registerName));
	}

	private static boolean isValidUnit(String input) {
		return Parser.makeInteger(input) % 10 == VALID_UNIT;
	}

	private static boolean isNumber(String input) {
		return input.chars().allMatch(Character::isDigit);
	}

	private static boolean isBlanked(String input) {
		return input.length() == 0;
	}

	private static boolean isLastIndexSemiColon(String line) {
		return line.lastIndexOf(INVALID_CHAR) == line.length() - 1;
	}
}
