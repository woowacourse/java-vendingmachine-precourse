package vendingmachine.validator;

import static vendingmachine.Constants.*;

import vendingmachine.view.ErrorView;

public class MoneyValidator extends PositiveValidator {
	public static boolean checkInputMoney(String string) {
		try {
			exceptionNotPositiveNumber(string);
			exceptionStringNotDivideByTen(string);
			exceptionStringSmallerThanMinimum(string);
			return true;
		} catch (IllegalArgumentException exception) {
			ErrorView.error(ERROR_INPUT_MONEY);
			return false;
		}
	}

	protected static void exceptionStringNotDivideByTen(String string) {
		long number = getNumberFromString(string);
		if (number % MIN_INPUT_MONEY != 0) {
			throw new IllegalArgumentException();
		}
	}

	protected static void exceptionStringSmallerThanMinimum(String string) {
		long number = getNumberFromString(string);
		if (number <= MIN_INPUT_MONEY) {
			throw new IllegalArgumentException();
		}
	}

	protected static long getNumberFromString(String string) {
		exceptionStringNotNumber(string);
		return Long.parseLong(string);
	}
}
