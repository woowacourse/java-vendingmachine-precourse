package vendingmachine.Model.Validator;

import vendingmachine.Constants;

public class MoneyValidator {
	public final String MONEY_STRING;
	public final int MONEY;

	public MoneyValidator(String money) {
		this.MONEY_STRING = money;
		validate();
		this.MONEY = Integer.parseInt(MONEY_STRING);
	}

	private void validate() {
		isRightUnit();
		isRightString();
		isRightRange();
	}

	private void isRightUnit() {
		if (MONEY_STRING.charAt(MONEY_STRING.length() - 1) != Constants.MONEY_UNIT) {
			throw new IllegalArgumentException(Constants.ERROR_MONEY_UNIT);
		}
	}

	private void isRightString() {
		if (!Constants.MONEY_PATTERN.matcher(MONEY_STRING).matches()) {
			throw new IllegalArgumentException(Constants.ERROR_MONEY_PATTERN);
		}
	}

	private void isRightRange() {
		if (Integer.parseInt(MONEY_STRING) < Constants.MIN_MONEY) {
			throw new IllegalArgumentException(Constants.ERROR_MONEY_RANGE);
		}
	}
}
