package vendingmachine;

import java.util.ArrayList;
import java.util.HashMap;
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

	public static List<Integer> getAllCoins() {
		List<Integer> possibleCoins = new ArrayList<>();
		for (Coin each : Coin.values()) {
			possibleCoins.add(each.getAmount());
		}
		return possibleCoins;
	}

	public static Coin issue(int amount) {
		HashMap<Integer, Coin> coinMap = new HashMap<>();
		for (Coin each : Coin.values()) {
			coinMap.put(each.getAmount(), each);
		}
		return coinMap.get(amount);
	}
}
