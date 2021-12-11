package vendingmachine.exception;

import static vendingmachine.constant.Constant.*;
import static vendingmachine.constant.ErrorMessage.*;

public class NumberException {

	public static void checkNumberException(String number) {
		checkNumberEmpty(number);
		checkNumberIsInteger(number);
		checkNegativeNumber(number);
		checkDivisionMinimumCoinAmount(number);

	}

	private static void checkNumberEmpty(String number) {
		if (number == null || number.trim().isEmpty()) {
			throw new IllegalArgumentException(NUMBER_EMPTY_ERROR_MASSAGE);
		}
	}

	private static void checkNumberIsInteger(String number) {
		if (!number.chars().allMatch(Character::isDigit)) {
			throw new IllegalArgumentException(NUMBER_NOT_INTEGER_ERROR_MESSAGE);
		}
	}

	private static void checkNegativeNumber(String number) {
		if (Integer.parseInt(number) < DISCRIMINATION_NEGATIVE_NUMBER) {
			throw new IllegalArgumentException(NUMBER_IS_NEGATIVE_ERROR_MESSAGE);
		}
	}

	private static void checkDivisionMinimumCoinAmount(String number) {
		if (Integer.parseInt(number) % MINIMUM_COIN_AMOUNT != 0) {
			throw new IllegalArgumentException(NUMBER_NOT_DIVIDE_MINIMUM_COIN_AMOUNT);
		}
	}
}
