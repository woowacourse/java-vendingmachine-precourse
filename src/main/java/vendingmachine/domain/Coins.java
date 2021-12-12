package vendingmachine.domain;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class Coins {
	private static final int ZERO = 0;
	private final Map<Integer, Integer> coins;

	public Coins(Map<Integer, Integer> coins) {
		this.coins = coins;
	}

	public Map<Integer, Integer> findAll() {
		return Collections.unmodifiableMap(coins);
	}

	public Map<Integer, Integer> findRestCoins() {
		Map<Integer, Integer> restCoins = new LinkedHashMap<>();
		for (Integer coin : coins.keySet()) {
			Integer number = coins.get(coin);
			if (number <= ZERO) {
				continue;
			}
			restCoins.put(coin, number);
		}
		return restCoins;
	}
}
