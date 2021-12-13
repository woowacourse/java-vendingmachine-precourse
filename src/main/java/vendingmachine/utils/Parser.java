package vendingmachine.utils;

import static vendingmachine.constants.Constant.INFO_SPLIT_CRITERIA;

public class Parser {
	private Parser() {

	}

	public static String[] parsingItemInfo(String itemInfo) {
		Validator.validateItemInfoFormat(itemInfo);
		String data = removeSquareBrackets(itemInfo);

		return splitLine(data, INFO_SPLIT_CRITERIA);
	}

	public static String[] splitLine(String line, String criteria) {
		return line.split(criteria);
	}

	public static Integer makeInteger(String str) {
		return Integer.parseInt(str);
	}

	private static String removeSquareBrackets(String info) {
		return info.substring(1, info.length() - 1);
	}
}
