package vendingmachine.util;

import vendingmachine.view.ErrorMessage;

public class MoneyValidator {

	public static final String MONEY_FORM = "[1-9][0-9]*0";

	public static void validate(String inputString) {
		if (!inputString.matches(MONEY_FORM)) {
			throw new IllegalArgumentException(ErrorMessage.WRONG_MONEY_INPUT);
		}
	}
}
