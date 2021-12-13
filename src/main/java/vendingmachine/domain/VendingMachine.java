package vendingmachine.domain;

public class VendingMachine {
	private Coins coins;
	private Products products;
	private Balance balance;

	public VendingMachine(Coins coins, Products products, Balance balance) {
		this.coins = coins;
		this.products = products;
		this.balance = balance;
	}

	public boolean isContinueVendingMachine() {
		if (balance.isValidateHasBalanceZero()) {
			return false;
		}

		return true;
	}
}
