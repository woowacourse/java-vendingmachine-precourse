package vendingmachine.domain;

public enum Coin {
	COIN_500(500),
	COIN_100(100),
	COIN_50(50),
	COIN_10(10),
	;

	private final int amount;

	Coin(final int amount) {
		this.amount = amount;
	}

	public int getAmount() {
		return amount;
	}

	public static Coin valueOf(int value) {
		for (Coin coin : Coin.values()) {
			if (coin.getAmount() == value) {
				return coin;
			}
		}
		return null;
	}

}
