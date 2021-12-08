package vendingmachine.Model;

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
		isRightString();
		isRightRange();
		isRightUnit();
	}

	private void isRightString() {
		if (!Constants.MONEY_PATTERN.matcher(MONEY_STRING).matches()) {
			throw new IllegalArgumentException(Constants.ERROR);
		}
	}

	private void isRightRange() {
		if (Integer.parseInt(MONEY_STRING) < 100) {
			throw new IllegalArgumentException(Constants.ERROR);
		}
	}

	private void isRightUnit() {
		if (Integer.parseInt(MONEY_STRING) % 10 != 0) {
			throw new IllegalArgumentException(Constants.ERROR);
		}
	}
}
