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

	public static Coin valueOf(int amount) {
		if (amount == 500) {
			return COIN_500;
		}
		if (amount == 100) {
			return COIN_100;
		}
		if (amount == 50) {
			return COIN_50;
		}
		return COIN_10;
	}

	public int getAmount() {
		return this.amount;
	}
}
