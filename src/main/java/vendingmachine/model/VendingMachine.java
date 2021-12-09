package vendingmachine.model;

public class VendingMachine {

	private final CoinsCase coinsCase;
	private final int amount;

	public VendingMachine(int amount) {
		this.amount = amount;
		this.coinsCase = new CoinsCase(amount);
	}

	public CoinsCase getCoinsCase() {
		return coinsCase;
	}
}
