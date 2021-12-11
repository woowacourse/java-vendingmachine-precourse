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

	public int getAmount() {
		return amount;
	}

	public static Coin valueOf(int amount) {
		Coin[] coins = values();
		return Arrays.stream(coins)
			.filter(coin -> coin.getAmount() == amount)
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("해당 가격의 코인은 존재하지 않습니다."));
	}

}
