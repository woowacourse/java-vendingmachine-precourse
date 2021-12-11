package vendingmachine.resource;

public enum Coin {
	COIN_500(500),
	COIN_100(100),
	COIN_50(50),
	COIN_10(10);

	private final int amount;

	Coin(final int amount) {
		this.amount = amount;
	}

	// 추가 기능 구현
	public int getAmount() {
		return amount;
	}

	public static Coin getCoinFromAmount(int amount) {
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
}
