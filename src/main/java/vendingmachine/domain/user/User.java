package vendingmachine.domain.user;

import vendingmachine.domain.machine.Machine;

public class User {

	private Machine machine;
	private Balance balance = new Balance();

	public User(Machine machine) {
		this.machine = machine;
	}

	public void depositMoney(int money) {
		balance.deposit(money);
	}

	public void purchase(String productName) {
		machine.purchaseProduct(balance, productName);
	}

}
