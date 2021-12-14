package vendingmachine.utils;

import static vendingmachine.constants.Constant.*;
import static vendingmachine.constants.Message.*;

import java.util.List;
import java.util.regex.Pattern;

import vendingmachine.domain.Item;

public class Validator {
	private Validator() {

	}

	public static void validatePossession(int possession) {
		validateUnit(possession);
	}

	public static void validatePrice(int price) {
		validateUnit(price);
		validateRange(price, MIN_ADD_PRICE_VALUE, ERROR_INVALID_ADD_ITEM_PRICE);
	}

	public static void validateStock(int stock) {
		validateRange(stock, MIN_ADD_STOCK_VALUE, ERROR_INVALID_ADD_ITEM_STOCK);
	}

	public static void validateUserMoney(int userMoney) {
		validateUnit(userMoney);
		validateRange(userMoney, MIN_INPUT_MONEY_VALUE, ERROR_INVALID_INPUT_MONEY);
	}

	public static void validateItemInfoFormat(String itemInfoLine) {
		boolean isValidFormat = Pattern.matches(VALIDATE_ITEM_INFO_FORMAT, itemInfoLine);

		if (!isValidFormat) {
			throw new IllegalArgumentException(ERROR_INVALID_ITEM_FORMAT);
		}
	}

	public static void validateUnit(int number) {
		if (!isValidUnit(number)) {
			throw new IllegalArgumentException(ERROR_INVALID_UNIT_NUMBER);
		}
	}

	public static void validateRange(int number, int minRangeValue, String errorMessage) {
		if (!isValidRange(number, minRangeValue)) {
			throw new IllegalArgumentException(errorMessage);
		}
	}

	private static boolean isValidRange(int number, int minRangeValue) {
		return number >= minRangeValue;
	}

	public static void validateAddingItemName(String registerName, List<Item> registeredItems) {
		if (isDuplicatedName(registerName, registeredItems)) {
			throw new IllegalArgumentException(ERROR_DUPLICATED_ADD_ITEM_NAME);
		}
	}

	public static void validatePurchaseItemName(String purchaseName, List<Item> forSaleList) {
		if (!isDuplicatedName(purchaseName, forSaleList)) {
			throw new IllegalArgumentException(ERROR_NO_ITEM_NAME_EXIST);
		}
	}

	public static void validateAddingItemsLineFormat(String addingItemsInputLine) {
		if (isLastIndexSemiColon(addingItemsInputLine)) {
			throw new IllegalArgumentException(ERROR_INVALID_ADD_ITEMS_FORMAT);
		}
	}

	private static boolean isDuplicatedName(String name, List<Item> otherItems) {
		return otherItems.stream().anyMatch(o -> o.isSameName(name));
	}

	private static boolean isValidUnit(int number) {
		return number % VALID_UNIT_CHECKER == VALID_UNIT;
	}

	private static boolean isLastIndexSemiColon(String line) {
		return line.lastIndexOf(INVALID_CHAR) == line.length() - 1;
	}
}
