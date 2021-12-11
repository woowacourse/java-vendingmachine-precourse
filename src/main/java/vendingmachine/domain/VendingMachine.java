package vendingmachine.domain;

import vendingmachine.Validation;

public class VendingMachine {
	private Coins coins;

	public void initializeCoins(String input) {
		int coinBalance = Validation.isValidBalance(input);
		this.coins = new Coins(coinBalance);
		coins.createRandomCoins();
	}
}
