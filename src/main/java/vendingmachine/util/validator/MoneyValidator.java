package vendingmachine.util.validator;

import vendingmachine.util.ErrorMessageConstants;

public class MoneyValidator {
	private static final int POSITIVE_NUMBER_BOUNDARY = 0;
	private static final int DIVISOR = 10;
	private static final int REMAINDER = 0;

	private MoneyValidator() {
	}

	public static void validate(String money) {
		validateInteger(money);
		validateRange(Integer.parseInt(money));
		validateDivision(Integer.parseInt(money));
	}

	public static void validateInsertMoney(String money) {
		validateInteger(money);
		validateRange(Integer.parseInt(money));
	}

	private static void validateInteger(String money) {
		try {
			Integer.parseInt(money);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ErrorMessageConstants.INTEGER_EXCEPTION_MESSAGE);
		}
	}

	private static void validateRange(int money) {
		if (money < POSITIVE_NUMBER_BOUNDARY) {
			throw new IllegalArgumentException(ErrorMessageConstants.POSITIVE_NUMBER_EXCEPTION_MESSAGE);
		}
	}

	private static void validateDivision(int money) {
		if (money % DIVISOR != REMAINDER) {
			throw new IllegalArgumentException(ErrorMessageConstants.DIVISION_EXCEPTION_MESSAGE);
		}
	}
}
