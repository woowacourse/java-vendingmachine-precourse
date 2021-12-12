package vendingmachine.util.validator;

import vendingmachine.util.ErrorMessageConstants;

public class MoneyValidator {
	private static final int POSITIVE_NUMBER_BOUNDARY = 0;

	private MoneyValidator() {
	}

	public static void validate(String money) {
		validateInteger(money);
		validateRange(Integer.parseInt(money));
	}

	private static void validateInteger(String money) {
		try {
			Integer.parseInt(money);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ErrorMessageConstants.INTEGER_ERROR);
		}
	}

	private static void validateRange(int money) {
		if (money < POSITIVE_NUMBER_BOUNDARY) {
			throw new IllegalArgumentException(ErrorMessageConstants.POSITIVE_NUMBER_EXCEPTION_MESSAGE);
		}
	}
}
