package vendingmachine.model;

import vendingmachine.validation.UserValidation;
import vendingmachine.view.ErrorView;
import vendingmachine.view.InputView;

public class User {

	private int balance;

	public User() {
		setUser();
	}

	private void setUser() {
		try {
			String input = InputView.setUserBalance();
			UserValidation.setUserBalance(input);
			this.balance = Integer.parseInt(input);
		} catch (IllegalArgumentException illegalArgumentException) {
			ErrorView.illegalArgumentException(illegalArgumentException.getMessage());
		}

	}
}
