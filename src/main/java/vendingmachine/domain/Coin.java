package vendingmachine.domain;

import java.util.Arrays;
import java.util.List;

import vendingmachine.exception.NotFoundCoinException;

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

	public static List<Integer> getList() {
		return Arrays.asList(10, 50, 100, 500);
	}

	public static Coin getCoin(int amount) {
		return Arrays.stream(Coin.values())
			.filter(coin -> coin.amount == amount)
			.findAny()
			.orElseThrow(NotFoundCoinException::new);
	}
}
