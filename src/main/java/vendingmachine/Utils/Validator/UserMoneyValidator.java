package vendingmachine.Utils.Validator;

import vendingmachine.Utils.Constants;

public class UserMoneyValidator extends MoneyValidator {

	public UserMoneyValidator(String money, int minPrice) {
		super(money);
		isRightRange(Integer.parseInt(money), minPrice);
	}

	private void isRightRange(int money, int minPrice) {
		if (money < minPrice) {
			throw new IllegalArgumentException(Constants.ERROR_USER_POOR);
		}
	}
}
