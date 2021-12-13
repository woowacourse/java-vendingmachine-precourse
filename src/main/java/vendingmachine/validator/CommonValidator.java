package vendingmachine.validator;

import static vendingmachine.Constants.*;

public class CommonValidator {
	protected static boolean checkString(String string) {
		try {
			exceptionStringEmpty(string);
			exceptionStringSpace(string);
			return true;
		} catch (IllegalArgumentException exception) {
			return false;
		}
	}

	protected static void exceptionStringEmpty(String string) {
		if (string.equals(EMPTY_STRING)) {
			throw new IllegalArgumentException();
		}
	}

	protected static void exceptionStringSpace(String string) {
		if (string.equals(" ")) {
			throw new IllegalArgumentException();
		}
	}
}
