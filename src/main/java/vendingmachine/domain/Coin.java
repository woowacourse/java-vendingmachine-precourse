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

	public static Coin matchValue(int amount) {
		for (Coin coin : Coin.values()) {
			if (coin.getAmount() == amount) {
				return coin;
			}
		}
		return null;
	}

	public int getAmount() {
		return this.amount;
	}
}
