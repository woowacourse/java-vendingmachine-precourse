package vendingmachine.domain;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class Coins {
	private static final int NUMBER_LOWER_BOUND = 0;
	private final Map<Integer, Integer> coins;

	public Coins(final Map<Integer, Integer> coins) {
		this.coins = coins;
	}

	public Map<Integer, Integer> findAll() {
		return Collections.unmodifiableMap(coins);
	}

	public Map<Integer, Integer> findRestCoins() {
		Map<Integer, Integer> restCoins = new LinkedHashMap<>();
		for (Integer coin : coins.keySet()) {
			Integer number = coins.get(coin);
			if (NUMBER_LOWER_BOUND < number) {
				restCoins.put(coin, number);
			}
		}
		return restCoins;
	}

	public void update(final Map<Integer, Integer> reducedCoins) {
		for (Integer coin : reducedCoins.keySet()) {
			coins.put(coin, coins.get(coin) - reducedCoins.get(coin));
		}
	}
}
