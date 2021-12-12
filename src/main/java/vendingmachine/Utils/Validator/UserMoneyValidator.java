package vendingmachine.Utils.Validator;

import vendingmachine.Utils.Constants;

public class UserMoneyValidator extends MoneyValidator {
	private final int minPrice;

	public UserMoneyValidator(String moneyString, int minPrice) {
		super(moneyString);
		this.minPrice = minPrice;
		isRightRange();
	}

	private void isRightRange() {
		if (Integer.parseInt(moneyString) < minPrice) {
			throw new IllegalArgumentException(Constants.ERROR_USER_POOR);
		}
	}
}
