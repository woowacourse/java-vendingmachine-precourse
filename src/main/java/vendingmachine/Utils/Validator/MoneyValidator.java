package vendingmachine.Utils.Validator;

import vendingmachine.Utils.Constants;

public class MoneyValidator {
	public MoneyValidator(String money) {
		isRightUnit(money);
		isRightString(money);
		isRightRange(Integer.parseInt(money));
	}

	private void isRightUnit(String money) {
		if (money.charAt(money.length() - 1) != Constants.MONEY_UNIT) {
			throw new IllegalArgumentException(Constants.ERROR_MONEY_UNIT);
		}
	}

	private void isRightString(String money) {
		if (!Constants.MONEY_PATTERN.matcher(money).matches()) {
			throw new IllegalArgumentException(Constants.ERROR_MONEY_PATTERN);
		}
	}

	private void isRightRange(int money) {
		if (money < Constants.MIN_MONEY) {
			throw new IllegalArgumentException(Constants.ERROR_MONEY_RANGE);
		}
	}
}
