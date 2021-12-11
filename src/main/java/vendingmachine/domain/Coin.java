package vendingmachine.domain;

import java.util.EnumMap;
import java.util.Map;

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
		return this.amount;
	}

	public static Map<Coin, Integer> getCoin() {
		Map<Coin, Integer> coin = new EnumMap<Coin, Integer>(Coin.class);
		coin.put(COIN_500, 0);
		coin.put(COIN_100, 0);
		coin.put(COIN_50, 0);
		coin.put(COIN_10, 0);
		return coin;
	}
}
