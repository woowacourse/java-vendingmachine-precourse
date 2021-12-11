package vendingmachine.domain;

import java.util.Collections;
import java.util.Map;

public class Coins {
	private final Map<Integer, Integer> coins;

	public Coins(Map<Integer, Integer> coins) {
		this.coins = coins;
	}

	public Map<Integer, Integer> getCoins() {
		return Collections.unmodifiableMap(coins);
	}
}
