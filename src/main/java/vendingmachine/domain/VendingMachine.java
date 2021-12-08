package vendingmachine.domain;

public class VendingMachine {
	private CoinStore coinStore;

	public VendingMachine(int money) {
		coinStore = new CoinStore(money);
	}

	public String getHoldingAmountCoins() {
		return coinStore.toString();
	}
}
