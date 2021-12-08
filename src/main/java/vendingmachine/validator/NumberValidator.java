package vendingmachine.validator;

import static constants.VendingMachineConstants.*;

public class NumberValidator {
	public static void checkNumber(String input) {
		isNumber(input);
		isUpperZero(input);
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
}
