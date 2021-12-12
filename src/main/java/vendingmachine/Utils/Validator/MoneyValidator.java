package vendingmachine.Utils.Validator;

import vendingmachine.Utils.Constants;

public class MoneyValidator {
	public MoneyValidator(String money) {
		isRightString(money);
		isRightUnit(money);
		isRightRange(Integer.parseInt(money));
	}

	private void isRightString(String money) {
		if (!Constants.NUMBER_PATTERN.matcher(money).matches()) {
			throw new IllegalArgumentException(Constants.ERROR_NUMBER_PATTERN);
		}
	}

	private void isRightUnit(String money) {
		if (money.charAt(money.length() - 1) != Constants.MONEY_UNIT) {
			throw new IllegalArgumentException(Constants.ERROR_MONEY_UNIT);
		}
	}

	private void isRightRange(int money) {
		if (money < Constants.MIN_MONEY) {
			throw new IllegalArgumentException(Constants.ERROR_MONEY_RANGE);
		}
	}
}
