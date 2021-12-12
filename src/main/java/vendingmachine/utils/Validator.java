package vendingmachine.utils;

import java.util.ArrayList;
import java.util.HashMap;

import vendingmachine.models.Item;

public class Validator {
	private static final String NUMBER_PATTERN = "^[0-9]+$";
	private static final String NAME_PATTERN = "^[0-9|a-z|A-Z|ㄱ-ㅎ|ㅏ-ㅣ|가-힣]+$";
	private static final int ELEMENT_SIZE = 3;

	private static void validateEmptyStr(String input) throws IllegalArgumentException {
		if (input.isEmpty()) {
			throw new IllegalArgumentException(
				Messages.ERROR_BLANK.getValue() + Messages.COMMON_LINE_BREAK_MSG.getValue());
		}
	}

	private static void validatePositive(String input) throws IllegalArgumentException {
		if (Integer.valueOf(input) <= 0) {
			throw new IllegalArgumentException(
				Messages.ERROR_NOT_POSITIVE.getValue() + Messages.COMMON_LINE_BREAK_MSG.getValue());
		}
	}

	private static void validateNumber(String input) throws IllegalArgumentException {
		if (!input.matches(NUMBER_PATTERN)) {
			throw new IllegalArgumentException(
				Messages.ERROR_NOT_NUMBER.getValue() + Messages.COMMON_LINE_BREAK_MSG.getValue());
		}
	}

	private static void validateName(String input) throws IllegalArgumentException {
		if (!input.matches(NAME_PATTERN)) {
			throw new IllegalArgumentException(
				Messages.ERROR_NOT_VALID_NAME.getValue() + Messages.COMMON_LINE_BREAK_MSG.getValue());
		}
	}

	private static void validateRemainder(String input, int minValue) throws IllegalArgumentException {
		if (Integer.valueOf(input) % minValue != 0) {
			throw new IllegalArgumentException(
				Messages.ERROR_NOT_DIVIDABLE_MESSAGE.getValue() + Messages.COMMON_LINE_BREAK_MSG.getValue());
		}
	}

	public static void validateElementSize(String[] itemInput) throws IllegalArgumentException {
		if (itemInput.length != ELEMENT_SIZE)
			throw new IllegalArgumentException(
				Messages.ERROR_NOT_VALID_ELEMENT_SIZE.getValue() + Messages.COMMON_LINE_BREAK_MSG.getValue());
	}

	public static void validateItemSize(ArrayList<String[]> itemInput) throws IllegalArgumentException {
		if (itemInput.isEmpty())
			throw new IllegalArgumentException(
				Messages.ERROR_NOT_VALID_ITEM_SIZE.getValue() + Messages.COMMON_LINE_BREAK_MSG.getValue());
	}

	public static void isItemName(HashMap<String, Item> ItemList, String inputName) throws IllegalArgumentException {
		if (!ItemList.containsKey(inputName)) {
			throw new IllegalArgumentException(
				Messages.ERROR_NOT_CONTAIN_MESSAGE.getValue() + Messages.COMMON_LINE_BREAK_MSG.getValue());
		}
	}

	public static void validatePayAmount(HashMap<String, Item> ItemList, String inputName, int pay) throws
		IllegalArgumentException {
		if (ItemList.get(inputName).isOverThisPrice(pay)) {
			throw new IllegalArgumentException(
				Messages.ERROR_NOT_ENOUGH_MONEY_MESSAGE + Messages.COMMON_LINE_BREAK_MSG.getValue());
		}
	}
}
