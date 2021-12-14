package vendingmachine.exception;

import static vendingmachine.constant.Error.*;

public class PriceValidator {

	public static void validatePrice(String input) {
		validateInt(input);
		validateBiggerThan100(input);
		validateTenMultiple(input);
	}

	public static void validateInitPrice(String input) {
		validateInt(input);
		validateBiggerThanZERO(input);
		validateTenMultiple(input);
	}

	public static void validateInt(String input) {
		try {
			Integer.parseInt(input);
		} catch (Exception e) {
			throw new IllegalArgumentException(ERROR_INPUT_INT);
		}
	}

	public static void validateBiggerThanZERO(String input) {
		if (Integer.parseInt(input) <= 0) {
			throw new IllegalArgumentException(ERROR_INPUT_INT_BIGGER_0);
		}
	}

	public static void validateBiggerThan100(String input) {
		if (Integer.parseInt(input) < 100) {
			throw new IllegalArgumentException(ERROR_INPUT_INT_BIGGER_100);
		}
	}

	public static void validateTenMultiple(String input) {
		int price = Integer.parseInt(input);
		if (!(price % 10 == 0)) {
			throw new IllegalArgumentException(ERROR_INPUT_INT_MULTIPLE_10);
		}
	}
}
