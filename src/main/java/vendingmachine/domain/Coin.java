package vendingmachine.domain;

import java.util.Arrays;
import java.util.List;

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

	public static Coin[] getCoinArray() {
		return Coin.values();
	}

	public static List<Integer> getIntCoinList() {
        List<Integer> coinList = Arrays.asList(500,100,50,10);
		return coinList;
	}

	public static Coin getCoinByAmount(int amount) {
		for (Coin coin: getCoinArray()) {
			if (coin.getAmount() == amount) {
				return coin;
			}
		}
		throw new IllegalArgumentException();
	}
}
