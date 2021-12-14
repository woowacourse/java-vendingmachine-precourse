package vendingmachine.domain;

import java.util.Map;
import java.util.TreeMap;

public class Coins {
	private final Map<Coin, Integer> coinCount = new TreeMap<>();

	public Coins(int inputMoneyOfVendingMachine) {
		createRandomCoinList(inputMoneyOfVendingMachine);
	}

	public Coins() {
		for (Coin coinName : Coin.values()) {
			coinCount.put(coinName, 0);
		}
	}

	public Map<Coin, Integer> getCoinCount() {
		return coinCount;
	}

	public int getCoinSum() {
		int sum = 0;
		for (Coin coin : coinCount.keySet()) {
			sum += coin.getAmount() * coinCount.get(coin);
		}
		return sum;
	}

	private void createRandomCoinList(int vendingMachineMoney) {
		for (Coin coinName : Coin.values()) {
			coinCount.put(coinName, 0);
		}

		Integer randomCoin;
		while (vendingMachineMoney != 0) {
			randomCoin = Coin.getRandomAmount();
			if (randomCoin <= vendingMachineMoney) {
				vendingMachineMoney -= randomCoin;
				Coin randomCoinName = findCoinByValue(randomCoin);
				coinCount.replace(randomCoinName, coinCount.get(randomCoinName) + 1);
			}
		}
	}

	private Coin findCoinByValue(int coinValue) {
		for (Coin coin : Coin.values()) {
			if (coin.getAmount() == coinValue) {
				return coin;
			}
		}
		return null;
	}
}
