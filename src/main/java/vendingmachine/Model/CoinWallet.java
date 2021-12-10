package vendingmachine.Model;

import java.util.LinkedHashMap;

import vendingmachine.Util;

public class CoinWallet {
	public int money;
	public final LinkedHashMap<Coin, Integer> coins = new LinkedHashMap<>();

	public CoinWallet() {
	}

	public CoinWallet(int money) {
		this.money = money;
		coinInit();
		while (this.money != 0) {
			coinRandomAdd();
		}
	}

	public int getNum(Coin coin) {
		return coins.get(coin);
	}

	public void set(Coin coin, int coinCount) {
		coins.put(coin, coinCount);
	}

	private void coinInit() {
		for (Coin coin : Coin.values()) {
			coins.put(coin, 0);
		}
	}

	private void coinRandomAdd() {
		Coin coin = Util.randomCoin();
		if (money >= coin.getAmount()) {
			coins.replace(coin, coins.get(coin) + 1);
			money -= coin.getAmount();
		}
	}
}
