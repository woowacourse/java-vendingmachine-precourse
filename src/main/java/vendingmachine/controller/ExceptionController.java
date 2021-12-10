package vendingmachine.controller;

import vendingmachine.util.Constant;

public class ExceptionController {

	public static void isInteger(String input) {
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(Constant.ERROR_IS_NOT_INTEGER);
		}
	}

	public static void isPositive(int input) {
		if (input < 1) {
			throw new IllegalArgumentException(Constant.ERROR_IS_NOT_POSITIVE);
		}
	}

	public static int isValidNumber(String input) {
		isInteger(input);
		int result = Integer.parseInt(input);
		isPositive(result);
		return result;
	}

	public static void isMultipleOfTen(int input) {
		if (input % 10 != 0) {
			throw new IllegalArgumentException(Constant.ERROR_IS_NOT_MULTIPLE_OF_TEN);
		}
	}

	public static void isInfoFormatValidate(String input) {
		if (input.charAt(0) != '[' || input.charAt(input.length() - 1) != ']') {
			throw new IllegalArgumentException(Constant.ERROR_IS_NOT_VALIDATE_INFO_FORMAT);
		}
	}

	public static void isNumberOfInfo3(String[] input) {
		if (input.length != 3) {
			throw new IllegalArgumentException(Constant.Error_IS_NOT_3_INFO);
		}
	}
}
