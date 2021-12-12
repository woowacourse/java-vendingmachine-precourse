package vendingmachine.Utils.Validator;

import vendingmachine.Model.Converter;
import vendingmachine.Utils.Constants;

public class MoneyValidator {
	protected final String moneyString;

	public MoneyValidator(String moneyString) {
		this.moneyString = moneyString;
		isRightString();
		isRightUnit();
		isRightRange();
	}

	private void isRightString() {
		if (!Constants.NUMBER_PATTERN.matcher(moneyString).matches()) {
			throw new IllegalArgumentException(Constants.ERROR_NUMBER_PATTERN);
		}
	}

	private void isRightUnit() {
		if (moneyString.charAt(moneyString.length() - 1) != Constants.MONEY_UNIT) {
			throw new IllegalArgumentException(Constants.ERROR_MONEY_UNIT);
		}
	}

	private void isRightRange() {
		if (Converter.getInt(moneyString) < Constants.MIN_MONEY) {
			throw new IllegalArgumentException(Constants.ERROR_MONEY_RANGE);
		}
	}
}
