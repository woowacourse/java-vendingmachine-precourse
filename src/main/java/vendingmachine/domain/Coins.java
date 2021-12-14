package vendingmachine.domain;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class Coins {
	private static final int NUMBER_LOWER_BOUND = 0;
	private final Map<Coin, Integer> coins;

	public Coins(final Map<Coin, Integer> coins) {
		this.coins = coins;
	}

	public Map<Coin, Integer> findAll() {
		return Collections.unmodifiableMap(coins);
	}

	public Map<Coin, Integer> findRestCoins() {
		Map<Coin, Integer> restCoins = new LinkedHashMap<>();
		for (Coin coin : coins.keySet()) {
			Integer number = coins.get(coin);
			if (NUMBER_LOWER_BOUND < number) {
				restCoins.put(coin, number);
			}
		}
		return restCoins;
	}

	public void update(final Map<Coin, Integer> reducedCoins) {
		for (Coin coin : reducedCoins.keySet()) {
			coins.put(coin, coins.get(coin) - reducedCoins.get(coin));
		}
	}
}
