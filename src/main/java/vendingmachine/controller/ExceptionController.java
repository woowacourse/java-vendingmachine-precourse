package vendingmachine.controller;

public class ExceptionController {
	private static final String NOT_MONEY_ERROR_MESSAGE = "10으로 나누어 떨어지는 0 이상의 정수여야 합니다.";
	private static final String NOT_INTEGER_ERROR_MESSAGE = "숫자가 아닙니다.";

	public static void checkZeroOrPositiveInt(int input) {
		if (input < 0) {
			throw new IllegalArgumentException(NOT_MONEY_ERROR_MESSAGE);
		}
	}

	public static void checkModTen(int input) {
		if (input % 10 != 0) {
			throw new IllegalArgumentException(NOT_MONEY_ERROR_MESSAGE);
		}
	}

	public static int parseToInt(String input) {
		try {
			return Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(NOT_INTEGER_ERROR_MESSAGE);
		}
	}
}
