package vendingmachine.controller;

import vendingmachine.util.Constant;

public class FormatController {
	public static String[] splitProducts(String input) {
		return input.split(";");
	}

	public static String removeParentheses(String input) {
		return input.substring(1, input.length() - 1);
	}

	public static String[] splitInfo(String input) {
		return input.split(",");
	}

	public static void isInfoFormatValidate(String input) {
		if (input.charAt(0) != '[' || input.charAt(input.length() - 1) != ']') {
			throw new IllegalArgumentException(Constant.ERROR_IS_NOT_VALIDATE_INFO_FORMAT);
		}
	}

	public static void isNumberOfInfo3(String[] input) {
		if (input.length != 3) {
			throw new IllegalArgumentException(Constant.ERROR_IS_NOT_3_INFO);
		}
	}
}
