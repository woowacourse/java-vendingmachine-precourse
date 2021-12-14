package vendingmachine.domain;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import vendingmachine.utill.RandomCoinGenerator;

public class Coins {
	private final LinkedHashMap<Coin, Integer> coins;

	public Coins() {
		coins = new LinkedHashMap<>();
		for (Coin coin : Coin.values()) {
			coins.put(coin, 0);
		}
	}

	public void generateCoins(int machineMoney) {
		while (machineMoney != 0) {
			int coin = RandomCoinGenerator.generateRandomCoin(getCoinTypes());
			if (coin <= machineMoney) {
				machineMoney -= coin;
				addCoin(coin);
			}
		}
	}

	private List<Integer> getCoinTypes() {
		List<Integer> coinTypes = new ArrayList<>();

		for (Coin coin : Coin.values()) {
			coinTypes.add(coin.getAmount());
		}

		return coinTypes;
	}

	private void addCoin(int coin) {
		Coin coinValue = Coin.matchValue(coin);
		coins.put(coinValue, coins.get(coinValue) + 1);
	}

	private void reduceCoin(Coin coin, int coinCount) {
		coins.put(coin, coins.get(coin) - coinCount);
	}

	public LinkedHashMap<Integer, Integer> getCoinCount() {
		LinkedHashMap<Integer, Integer> coinCount = new LinkedHashMap<>();

		for (Coin coin : Coin.values()) {
			coinCount.put(coin.getAmount(), coins.get(coin));
		}

		return coinCount;
	}

	public LinkedHashMap<Integer, Integer> calculateChange(int money) {
		LinkedHashMap<Integer, Integer> changeInfo = new LinkedHashMap<>();

		for (Coin coin : Coin.values()) {
			int coinCount = getChangeCoinCount(coin, money);
			if (coinCount > 0) {
				changeInfo.put(coin.getAmount(), coinCount);
				money -= coin.getAmount() * coinCount;
				reduceCoin(coin, coinCount);
			}
		}

		return changeInfo;
	}

	private int getChangeCoinCount(Coin coin, int money) {
		return Math.min(coins.get(coin), money / coin.getAmount());
	}
}
