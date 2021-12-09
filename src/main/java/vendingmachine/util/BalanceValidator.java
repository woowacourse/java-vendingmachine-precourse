package vendingmachine.util;

import vendingmachine.view.ErrorMessage;

public class BalanceValidator {

	public static final String NUMBER_ONLY = "[0-9]+";
	public static final String IMPOSSIBLE_FIRST_VALUE = "0";
	public static final int LENGTH_THRESHOLD = 1;
	public static final String POSSIBLE_LAST_VALUE = "0";

	public static void validate(String inputString) {
		canBeInteger(inputString);
		canBeCoin(inputString);
	}

	private static void canBeInteger(String inputString) {
		if (!inputString.matches(NUMBER_ONLY)) {
			throw new IllegalArgumentException(ErrorMessage.ONLY_INTEGER);
		}

		if (inputString.startsWith(IMPOSSIBLE_FIRST_VALUE)) {
			throw new IllegalArgumentException(ErrorMessage.START_WITH_ZERO);
		}
	}

	private static void canBeCoin(String inputString) {
		if (inputString.length() <= LENGTH_THRESHOLD) {
			throw new IllegalArgumentException(ErrorMessage.BALANCE_THRESHOLD);
		}

		if (!inputString.endsWith(POSSIBLE_LAST_VALUE)) {
			throw new IllegalArgumentException(ErrorMessage.BALANCE_UNIT);
		}
	}
}
