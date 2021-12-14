package vendingmachine.domain;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Coin {
	COIN_500(500),
	COIN_100(100),
	COIN_50(50),
	COIN_10(10);

	private static final Map<Integer, String> COIN_MAP = Collections.unmodifiableMap(
		Stream.of(values()).collect(Collectors.toMap(Coin::getAmount, Coin::name)));
	private final int amount;

	Coin(final int amount) {
		this.amount = amount;
	}

	public int getAmount() {
		return amount;
	}

	public static Coin of(int amount) {
		return Coin.valueOf(COIN_MAP.get(amount));
	}
}
