package vendingmachine.utils;

import static vendingmachine.constants.Constant.*;
import static vendingmachine.constants.Message.ERROR_IS_NOT_INTEGER;
import static vendingmachine.constants.Message.ERROR_IS_NOT_POSITIVE;

public class Parser {
	private Parser() {

	}

	public static String[] parsingItemInfo(String itemInfo) {
		Validator.validateItemInfoFormat(itemInfo);
		String data = removeSquareBrackets(itemInfo);

		return splitLine(data, DETAIL_ITEM_INFO_SPLIT_CRITERIA);
	}

	public static String[] splitLine(String line, String criteria) {
		return line.split(criteria);
	}

	public static Integer makeInteger(String str) {
		try {
			int number = Integer.parseInt(str);
			Validator.validateRange(number, MIN_INPUT_VALUE, ERROR_IS_NOT_POSITIVE);

			return number;
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ERROR_IS_NOT_INTEGER);
		}
	}

	private static String removeSquareBrackets(String info) {
		return info.substring(VALID_STRING_START_INDEX, info.length() - 1);
	}
}
