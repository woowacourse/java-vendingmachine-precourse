package vendingmachine.model;

import vendingmachine.utils.ExceptionUtils;

public class VendingMachine {

	private final CoinsCase coinsCase;

	public VendingMachine(int amount) {
		ExceptionUtils.validateMoney(amount);
		this.coinsCase = new CoinsCase(amount);
	}

	public CoinsCase getCoinsCase() {
		return coinsCase;
	}
}
