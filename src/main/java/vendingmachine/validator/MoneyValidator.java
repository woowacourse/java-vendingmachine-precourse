package vendingmachine.validator;

import static constants.VendingMachineConstants.*;

public class MoneyValidator {
	public static void checkNumber(String input) {
		isNumber(input);
		isUpperZero(input);
		isDivisibleByTen(input);
	}

	private static void isNumber(String input) {
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(MONEY_NOT_DIGIT_ERROR);
		}
	}

	private static void isUpperZero(String input) {
		if (Integer.parseInt(input) < 0) {
			throw new IllegalArgumentException(MONEY_NEGATIVE_NUM_ERROR);
		}
	}

	private static void isDivisibleByTen(String input) {
		if (Integer.parseInt(input) % 10 != 0) {
			throw new IllegalArgumentException(PRODUCT_PRICE_ERROR);
		}
	}
}
