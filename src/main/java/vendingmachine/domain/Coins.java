package vendingmachine.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class Coins {
	private static final int EMPTY = 0;
	private static final int QUANTITY = 1;

	private int coinBalance;
	private final Map<Coin, Integer> changeCoins = new LinkedHashMap<>();
	private final Map<Coin, Integer> changeableCoins = new LinkedHashMap<>();

	public Coins(int coinBalance) {
		this.coinBalance = coinBalance;
		initializeCoins();
	}

	private void initializeCoins() {
		changeCoins.put(Coin.COIN_500, EMPTY);
		changeCoins.put(Coin.COIN_100, EMPTY);
		changeCoins.put(Coin.COIN_50, EMPTY);
		changeCoins.put(Coin.COIN_10, EMPTY);
	}

	public void createRandomCoins() {
		while (coinBalance != EMPTY) {
			int randCoin = Coin.getRandomCoin();
			if (randCoin > coinBalance) {
				continue;
			}
			coinBalance -= randCoin;
			Coin coinName = Coin.nameOf(randCoin);
			changeCoins.replace(coinName, changeCoins.get(coinName) + QUANTITY);
		}
	}

	public Map<Coin, Integer> getChangeableCoins(Balance balance) {
		for (Map.Entry<Coin, Integer> coin : changeCoins.entrySet()) {
			updateCoinStatus(coin, balance);
		}
		return changeableCoins;
	}

	private void updateCoinStatus(Map.Entry<Coin, Integer> coin, Balance balance) {
		while (balance.getBalance() >= coin.getKey().getAmount() && coin.getValue() > EMPTY) {
			balance.reduceBalance(coin.getKey().getAmount());
			if (changeableCoins.containsKey(coin.getKey())) {
				changeableCoins.replace(coin.getKey(), changeableCoins.get(coin.getKey()) + QUANTITY);
				changeCoins.replace(coin.getKey(), coin.getValue() - QUANTITY);
				continue;
			}
			changeableCoins.put(coin.getKey(), QUANTITY);
			changeCoins.replace(coin.getKey(), coin.getValue() - QUANTITY);
		}
	}

	public Map<Coin, Integer> getCoins() {
		return changeCoins;
	}
}
