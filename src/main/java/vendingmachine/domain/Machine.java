package vendingmachine.domain;

import java.util.HashMap;
import java.util.Map;

import vendingmachine.util.MapSupporter;

public class Machine {
	Map<Coin, Integer> coins = new HashMap<>();

	public void addCoins(Map<Coin, Integer> coins) {
		for (Coin coin : coins.keySet()) {
			MapSupporter.increaseValue(this.coins, coin, 0, coins.get(coin));
		}
	}

	public Map<Coin, Integer> getCoins() {
		return this.coins;
	}
}
