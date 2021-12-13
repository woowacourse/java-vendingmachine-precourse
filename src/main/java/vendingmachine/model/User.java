package vendingmachine.model;

import vendingmachine.validation.UserValidation;
import vendingmachine.view.ErrorView;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

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
			setUser();
		}
	}

	public boolean canBuy(int price) {
		return balance >= price;
	}

	public void buyProduct(int price) {
		balance -= price;
	}

	public int getBalance() {
		return balance;
	}

	public void printRemain() {
		OutputView.remainBalance(balance);
	}
}
