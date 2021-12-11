package vendingmachine.Model;

import java.util.LinkedHashMap;

import vendingmachine.Utils.Util;

public class CoinGroup {
	protected final LinkedHashMap<Coin, Integer> coins = new LinkedHashMap<>();

	public CoinGroup() {
	}

	public CoinGroup(int money) {
		initiate();
		while (money != 0) {
			money = moneyToCoin(money);
		}
	}

	private void initiate() {
		for (Coin coin : Coin.values()) {
			coins.put(coin, 0);
		}
	}

	private int moneyToCoin(int money) {
		Coin coin = Util.randomCoin();
		if (money >= coin.getAmount()) {
			coins.replace(coin, coins.get(coin) + 1);
			money -= coin.getAmount();
		}
		return money;
	}

	public void set(Coin coin, int coinCount) {
		coins.put(coin, coinCount);
	}

	public LinkedHashMap<Coin, Integer> getMap() {
		return coins;
	}

	public LinkedHashMap<Coin, Integer> getNotEmptyMap() {
		LinkedHashMap<Coin, Integer> emptyCoins = new LinkedHashMap<>(coins);
		coins.keySet().stream()
			.filter(coin -> coins.get(coin) == 0)
			.forEach(emptyCoins::remove);
		return emptyCoins;
	}

	public int getStock(Coin coin) {
		return coins.get(coin);
	}
}
