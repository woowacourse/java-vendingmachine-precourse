package vendingmachine.validator;

import static vendingmachine.Constants.*;

public class PositiveValidator extends CommonValidator {
	public static boolean checkPositiveNumber(String string) {
		try {
			exceptionNotPositiveNumber(string);
			return true;
		} catch (IllegalArgumentException exception) {
			return false;
		}
	}

	protected static void exceptionNotPositiveNumber(String string) {
		exceptionStringNotNumber(string);
		exceptionStringZero(string);
		exceptionStringEmpty(string);
	}

	protected static void exceptionStringNotNumber(String string) {
		char[] letters = string.toCharArray();
		for (char letter : letters) {
			exceptionCharNotNumber(letter);
		}
	}

	protected static void exceptionStringZero(String string) {
		if (string.equals(STRING_ZERO)) {
			throw new IllegalArgumentException();
		}
	}

	protected static void exceptionCharNotNumber(char letter) {
		if (letter > CHAR_NINE || letter < CHAR_ZERO) {
			throw new IllegalArgumentException();
		}
	}
}
