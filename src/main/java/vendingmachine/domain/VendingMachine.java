package vendingmachine.domain;

public class VendingMachine {

	private Coins coins;

	public VendingMachine() {
		coins = new Coins();
	}

	public Coins getCoins() {
		return coins;
	}

	public void insertCoins(int amount) {
		coins.insertRandomCoins(amount);
	}
}
