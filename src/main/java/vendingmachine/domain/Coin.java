package vendingmachine.domain;

import java.util.Arrays;

public enum Coin {
	COIN_500(500),
	COIN_100(100),
	COIN_50(50),
	COIN_10(10);

	private final int amount;

	Coin(final int amount) {
		this.amount = amount;
	}

	public int toAmount() {
		return this.amount;
	}

	public static Coin findByAmount(int amount) {
		return Arrays.stream(Coin.values())
			.filter(e -> e.amount == amount)
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("해당하는 값이 없습니다."));
	}
}
