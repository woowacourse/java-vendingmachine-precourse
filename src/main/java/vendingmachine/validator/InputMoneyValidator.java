package vendingmachine.validator;

import static vendingmachine.Constants.*;

public class InputMoneyValidator {
	public static boolean checkInputMoney(String string) {
		try {
			exceptionStringNotNumber(string);
			exceptionStringZero(string);
			exceptionStringEmpty(string);
			exceptionStringNotDivideByTen(string);
			exceptionStringSmallerThanTen(string);
			return true;
		} catch (IllegalArgumentException exception) {
			return false;
		}
	}

	private static void exceptionStringNotNumber(String string) {
		char[] letters = string.toCharArray();
		for (char letter : letters) {
			exceptionCharNotNumber(letter);
		}
	}

	private static void exceptionStringZero(String string) {
		if (string.equals(STRING_ZERO)) {
			throw new IllegalArgumentException();
		}
	}

	private static void exceptionStringEmpty(String string) {
		if (string.equals(EMPTY_STRING)) {
			throw new IllegalArgumentException();
		}
	}

	private static void exceptionStringNotDivideByTen(String string) {
		long number = getNumberFromString(string);
		if (number % MIN_INPUT_MONEY != 0) {
			throw new IllegalArgumentException();
		}
	}


	private static void exceptionStringSmallerThanTen(String string) {
		long number = getNumberFromString(string);
		if (number <= MIN_INPUT_MONEY) {
			throw new IllegalArgumentException();
		}
	}

	private static void exceptionCharNotNumber(char letter) {
		if (letter > CHAR_NINE || letter < CHAR_ZERO) {
			throw new IllegalArgumentException();
		}
	}

	private static long getNumberFromString(String string) {
		exceptionStringNotNumber(string);
		return Long.parseLong(string);
	}
}
