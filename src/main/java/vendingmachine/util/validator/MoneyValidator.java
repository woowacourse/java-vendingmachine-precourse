package vendingmachine.util.validator;

import vendingmachine.util.ErrorMessageConstants;

public class MoneyValidator {
	public static void validate(String money) {
		validateInteger(money);
	}

	private static void validateInteger(String money) {
		try {
			Integer.parseInt(money);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ErrorMessageConstants.INTEGER_ERROR);
		}
	}
}
