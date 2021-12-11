package vendingmachine.model;

import java.util.LinkedHashMap;
import java.util.Set;

public class Coins {
	private final LinkedHashMap<Coin, Integer> coins;

	public Coins() {
		coins = new LinkedHashMap<>();
		coins.put(Coin.COIN_500, 0);
		coins.put(Coin.COIN_100, 0);
		coins.put(Coin.COIN_50, 0);
		coins.put(Coin.COIN_10, 0);
	}

	public Set<Coin> keySet() {
		return coins.keySet();
	}

	public void showAll() {
		for (Coin coin : coins.keySet()) {
			System.out.println(coin.getUnit() + " - " + coins.get(coin) + "개");
		}
	}

	public void showExists() {
		for (Coin coin : coins.keySet()) {
			if (coins.get(coin) > 0) {
				System.out.println(coin.getUnit() + " - " + coins.get(coin) + "개");
			}
		}
	}

	public void generate(int amount) {
		while (amount > 0) {
			int value = Coin.pickRandom();
			if (amount >= value) {
				amount -= value;
				Coin coin = Coin.valueOf(value);
				this.coins.replace(coin, this.coins.get(coin) + 1);
			}
		}
	}

	public int getAmount(Coin coin) {
		return coins.get(coin);
	}

	public void replace(Coin coin, int count) {
		this.coins.replace(coin, count);
	}
}
