package vendingmachine.domain;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class Coins {

	private static final int ZERO_AMOUNT = 0;
	private static final int PLUS_QUANTITY = 1;
	private static final int DEFAULT_QUANTITY = 0;
	private static final int ZERO_COUNT = 0;

	private Map<Coin, Integer> list;

	public Coins() {
		list = initializeCoins();
	}

	public Map<Coin, Integer> getList() {
		return list;
	}

	public void insertRandomCoins(int holdingAmount) {
		while (holdingAmount != ZERO_AMOUNT) {
			Coin coin = Coin.pickRandom();

			if (coin.isEnoughAmount(holdingAmount)) {
				holdingAmount = coin.calculateAmount(holdingAmount);
				list.put(coin, list.get(coin) + PLUS_QUANTITY);
			}
		}
	}

	public void processChange(Map<Coin, Integer> change, int amount) {
		for (Map.Entry<Coin, Integer> entry : list.entrySet()) {
			Coin coin = entry.getKey();
			Integer count = entry.getValue();

			int coinCount = coin.calculateCount(amount, count);
			if (coinCount != ZERO_COUNT) {
				change.put(coin, coinCount);
				amount = coin.calculateChange(amount, coinCount);
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
