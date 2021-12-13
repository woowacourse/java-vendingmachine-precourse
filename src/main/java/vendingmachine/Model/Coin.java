package vendingmachine.Model;

import vendingmachine.Utils.Constants;

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

	public String toString() {
		return Integer.toString(amount);
	}

	public static Coin getCoin(int amount) {
		return Coin.valueOf(Constants.COIN_NAME + amount);
	}
}
