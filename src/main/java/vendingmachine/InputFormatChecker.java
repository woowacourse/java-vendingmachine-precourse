package vendingmachine;

import java.util.regex.Pattern;

public class InputFormatChecker {
	private static final String NUMBER_REGULAR_EXPRESSION = "^[0-9]+$";
	private static final int MONEY_MINIMUM_UNIT = 10;

	private boolean checkNumber(String money) {
		if (Pattern.matches(NUMBER_REGULAR_EXPRESSION, money)) {
			return true;
		}
		return false;
	}

	private boolean checkDivideByMinimumUnit(String money, int minimumUnit) {
		if (Integer.parseInt(money) % minimumUnit == 0) {
			return true;
		}
		return false;
	}

	protected boolean checkMoneyFormat(String money) throws IllegalArgumentException {
		if (checkNumber(money) && checkDivideByMinimumUnit(money, MONEY_MINIMUM_UNIT)) {
			return true;
		}
		throw new IllegalArgumentException();
	}
}
