package vendingmachine.domain;

public enum Coin {
	COIN_500(500),
	COIN_100(100),
	COIN_50(50),
	COIN_10(10);

	private final int amount;

	Coin(final int amount) {
		this.amount = amount;
	}

	public static Coin valueOf(int inputAmount) {
		for (Coin coin : Coin.values()) {
			if (coin.amount == inputAmount) {
				return coin;
			}
		}
		return null;
	}

	public int getAmount() {
		return amount;
	}
}
