package vendingmachine.domain;

import java.util.stream.Stream;

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
	public static Coin findType(int amount) {
		return Stream.of(values())
				.filter(coin -> coin.amount == amount)
				.findAny()
				.orElse(null);
	}

	public int getAmount() {
		return amount;
	}
}
