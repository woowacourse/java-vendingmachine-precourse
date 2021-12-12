package vendingmachine.domain;

import java.util.HashMap;
import java.util.Map;

import vendingmachine.util.MapSupporter;

public class Machine {
	private final Map<Coin, Integer> coins = new HashMap<>();
	private Integer inputCoinAmount;
	private final Map<String, Item> items = new HashMap<>();

	public void addCoins(Map<Coin, Integer> coins) {
		for (Coin coin : coins.keySet()) {
			MapSupporter.increaseCoinCount(this.coins, coin, 0, coins.get(coin));
		}
	}

	public Map<Coin, Integer> getCoins() {
		return this.coins;
	}

	public void addInputCoinAmount(final int amount) {
		this.inputCoinAmount += amount;
	}

	public void addItems(Map<String, Item> items) {
		for (String itemName : items.keySet()) {
			this.items.put(itemName, items.get(itemName));
		}
	}
}
