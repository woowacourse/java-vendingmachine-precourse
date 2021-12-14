package vendingmachine.validator;

import static vendingmachine.Constants.*;

import vendingmachine.view.ErrorView;

public class CommonValidator {
	protected static boolean checkString(String string) {
		try {
			exceptionStringEmptyOrSpace(string);
			return true;
		} catch (IllegalArgumentException exception) {
			ErrorView.error(ERROR_STRING);
			return false;
		}
	}

	protected static void exceptionStringEmptyOrSpace(String inputLine) {
		exceptionStringEmpty(inputLine);
		exceptionStringSpace(inputLine);
	}

	protected static void exceptionStringEmpty(String string) {
		if (string.equals(EMPTY_STRING)) {
			throw new IllegalArgumentException();
		}
	}

	protected static void exceptionStringSpace(String string) {
		if (string.equals(STRING_SPACE)) {
			throw new IllegalArgumentException();
		}
	}
}
