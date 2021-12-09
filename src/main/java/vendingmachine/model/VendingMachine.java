package vendingmachine.model;

public class VendingMachine {

	private final CoinsCase coinsCase;

	public VendingMachine(int amount) {
		this.coinsCase = new CoinsCase(amount);
	}

	public CoinsCase getCoinsCase() {
		return coinsCase;
	}
}
