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
			throw new IllegalArgumentException(NUMBER_EMPTY_MSG);
		}
	}

	private static void checkNumberIsInteger(String number) {
		if (!number.chars().allMatch(Character::isDigit)) {
			throw new IllegalArgumentException(NUMBER_NOT_INTEGER_MSG);
		}
	}

	private static void checkNegativeNumber(String number) {
		if (Integer.parseInt(number) < DISCRIMINATION_NEGATIVE_NUMBER) {
			throw new IllegalArgumentException(NUMBER_NEGATIVE_MSG);
		}
	}

	private static void checkDivisionMinimumCoinAmount(String number) {
		if (Integer.parseInt(number) % MINIMUM_COIN_AMOUNT != 0) {
			throw new IllegalArgumentException(NUMBER_NOT_DIVIDE_MINIMUM_COIN_AMOUNT_MSG);
		}
	}
}
