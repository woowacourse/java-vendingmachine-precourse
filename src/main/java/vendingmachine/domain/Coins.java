package vendingmachine.domain;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class Coins {

	private static final int ZERO_AMOUNT = 0;
	private static final int PLUS_QUANTITY = 1;
	private static final int DEFAULT_QUANTITY = 0;

	private Map<Coin, Integer> list;

	public Coins() {
		list = initializeCoins();
	}

	public Map<Coin, Integer> getList() {
		return list;
	}

	public void insertRandomCoins(int totalAmount) {
		while (totalAmount != ZERO_AMOUNT) {
			Coin coin = Coin.pickRandom();

			if (coin.isEnoughAmount(totalAmount)) {
				totalAmount = coin.calculateAmount(totalAmount);
				list.put(coin, list.get(coin) + PLUS_QUANTITY);
			}
		}
	}

	private Map<Coin, Integer> initializeCoins() {
		list = new LinkedHashMap<>();

		Arrays.stream(Coin.values())
			.forEach(coin -> list.put(coin, DEFAULT_QUANTITY));

		return list;
	}
}
