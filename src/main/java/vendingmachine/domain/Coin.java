package vendingmachine.domain;

import java.util.ArrayList;
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

	public static Coin getCoin(final int amount) {
		for (Coin coin : Coin.values()) {
			if (coin.getAmount() == amount) {
				return coin;
			}
		}
		return null;
	}

	public static List<Integer> getCoinList() {
		List<Integer> coinList = new ArrayList<>();
		for (Coin value : Coin.values()) {
			coinList.add(value.amount);
		}
		return coinList;
	}
}
