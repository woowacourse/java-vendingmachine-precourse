package vendingmachine.type;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

	public static List<Integer> getCoinValues() {
		List<Integer> coinValues = Arrays.asList(Coin.values())
			.stream()
			.map(coin -> coin.getAmount())
			.collect(Collectors.toList());
		return coinValues;
	}

	public static List<Coin> getCoinList() {
		List<Coin> coinList = Arrays.asList(Coin.values());
		return coinList;
	}
}
