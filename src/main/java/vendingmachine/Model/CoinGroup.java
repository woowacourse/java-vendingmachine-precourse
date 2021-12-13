package vendingmachine.Model;

import java.util.LinkedHashMap;

import vendingmachine.Utils.Util;

public class CoinGroup {
	protected final LinkedHashMap<Coin, Integer> coins = new LinkedHashMap<>(); // 코인종류-코인개수 맵

	public CoinGroup() {
	}

	public CoinGroup(Money money) {
		initiate();
		moneyToCoin(money);
	}

	private void initiate() {
		for (Coin coin : Coin.values()) {
			coins.put(coin, 0);
		}
	}

	private void moneyToCoin(Money money) {
		Coin coin = Coin.getCoin(Util.randomCoinNumber());
		if (money.isBiggerOrSame(coin.getAmount())) {
			coins.replace(coin, coins.get(coin) + 1);
			money.spend(coin.getAmount());
		}
		if (!money.isEmpty()) {
			moneyToCoin(money);
		}
	}

	public void set(Coin coin, int coinCount) {
		coins.put(coin, coinCount);
	}

	public LinkedHashMap<Coin, Integer> get() {
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
