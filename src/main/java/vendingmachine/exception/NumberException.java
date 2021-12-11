package vendingmachine.exception;

import static vendingmachine.message.ErrorMessage.*;

public class NumberException {

	static final int DISCRIMINATION_NEGATIVE_NUMBER = 0;

	public static void checkNumberException(String number) {
		checkNumberEmpty(number);
		checkNumberIsInteger(number);
		checkNegativeNumber(number);

	}

	private static void checkNumberEmpty(String number) {
		if (number == null || number.trim().isEmpty()) {
			throw new IllegalArgumentException(NUMBER_EMPTY_ERROR_MASSAGE);
		}
	}

	private static void checkNumberIsInteger(String number) {
		if (number.chars().allMatch(Character::isDigit)) {
			throw new IllegalArgumentException(NUMBER_NOT_INTEGER_ERROR_MESSAGE);
		}
	}

	private static void checkNegativeNumber(String number) {
		if (Integer.parseInt(number) < DISCRIMINATION_NEGATIVE_NUMBER) {
			throw new IllegalArgumentException(NUMBER_IS_NEGATIVE_ERROR_MESSAGE);
		}
	}
}
