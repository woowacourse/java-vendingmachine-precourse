package vendingmachine.model;

public enum Coin {
	COIN_500(500),
	COIN_100(100),
	COIN_50(50),
	COIN_10(10);

	private final int amount;
	private static final String POSTFIX = "원";

	Coin(final int amount) {
		this.amount = amount;
	}

	public static Coin of(int amount) {
		for (Coin coin : Coin.values()) {
			if (coin.amount == amount) {
				return coin;
			}
		}
		return null;
	}

	public int divideByCoinAmount(int amount) {
		return amount / this.amount;
	}

	public int multiplyByCoinNumber(int coinNumber) {
		return coinNumber * this.amount;
	}

	@Override
	public String toString() {
		return this.amount + POSTFIX;
	}

	public boolean isReturnable(int insertMoney) {
		return insertMoney >= this.amount;
	}

	public int getAmount() {
		return this.amount;
	}
}
