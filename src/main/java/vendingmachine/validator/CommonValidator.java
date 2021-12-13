package vendingmachine.validator;

import static vendingmachine.Constants.*;

import vendingmachine.view.ErrorView;

public class CommonValidator {
	protected static boolean checkString(String string) {
		try {
			exceptionStringEmpty(string);
			exceptionStringSpace(string);
			return true;
		} catch (IllegalArgumentException exception) {
			ErrorView.error(ERROR_STRING);
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
