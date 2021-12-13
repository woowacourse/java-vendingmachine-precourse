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
		return Arrays.asList(COIN_10.getAmount(), COIN_50.getAmount(), COIN_100.getAmount(), COIN_500.getAmount());
	}

	public static Coin getCoin(int amount) {
		return Arrays.stream(Coin.values())
			.filter(coin -> coin.getAmount() == amount)
			.findAny()
			.orElseThrow(NotFoundCoinException::new);
	}
}
