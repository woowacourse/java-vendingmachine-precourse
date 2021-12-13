package vendingmachine.validator;

public class InputMoneyValidator {
	public static boolean checkInputMoney(String string) {
		try {
			exceptionStringNotNumber(string);
			exceptionStringZero(string);
			exceptionStringEmpty(string);
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
		if (string.equals("0")) {
			throw new IllegalArgumentException();
		}
	}

	private static void exceptionStringEmpty(String string) {
		if (string.equals("")) {
			throw new IllegalArgumentException();
		}
	}

	private static void exceptionCharNotNumber(char letter) {
		if (letter > '9' || letter < '0') {
			throw new IllegalArgumentException();
		}
	}
}
