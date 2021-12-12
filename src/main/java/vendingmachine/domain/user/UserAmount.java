package vendingmachine.domain.user;

import vendingmachine.validator.AmountValidator;

public class UserAmount {
	private int amount;

	public UserAmount(String amount) {
		AmountValidator.checkUserAmount(amount);
		this.amount = Integer.parseInt(amount);
	}
}
