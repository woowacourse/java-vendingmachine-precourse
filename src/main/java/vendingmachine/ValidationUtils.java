package vendingmachine;

import vendingmachine.view.Messages;

public class ValidationUtils {

	public static void validUnitMoney(int money) {
		if (money % 10 != 0) {
			throw new IllegalArgumentException(Messages.ERROR_NOT_MATCH_UNIT_MONEY);
		}
	}

	public static int validNumberFormat(String num) {
		try {
			return Integer.parseInt(num);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(Messages.ERROR_NOT_NUMBER);
		}
	}

	public static void isPositive(int num) {
		if (num <= 0) {
			throw new IllegalArgumentException(Messages.ERROR_NOT_POSITIVE);
		}
	}

	public static void isBlank(String testStr) {
		if (testStr.isEmpty()) {
			throw new IllegalArgumentException(Messages.ERROR_IS_BLANK);
		}
	}
}
