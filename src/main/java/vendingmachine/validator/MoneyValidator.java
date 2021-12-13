package vendingmachine.validator;

import static vendingmachine.constant.ExceptionMessage.*;

public class MoneyValidator {

	private static final String INTEGER_POSITIVE_REGEX = "^[0-9]+$";

	public static void validateInteger(String s) throws IllegalArgumentException {
		if (!s.matches(INTEGER_POSITIVE_REGEX))
			throw new IllegalArgumentException(MONEY_NOT_INTEGER.getMessage());
	}
}
