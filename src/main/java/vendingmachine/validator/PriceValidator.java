package vendingmachine.validator;

import static vendingmachine.Constants.*;

public class PriceValidator extends MoneyValidator {
	public static boolean checkPrice(String string) {
		try {
			exceptionNotPositiveNumber(string);
			exceptionStringSmallerThanMinimum(string);
			return true;
		} catch (IllegalArgumentException exception) {
			return false;
		}
	}

	protected static void exceptionStringSmallerThanMinimum(String string) {
		long number = getNumberFromString(string);
		if (number < MIN_PRICE) {
			throw new IllegalArgumentException();
		}
	}
}
