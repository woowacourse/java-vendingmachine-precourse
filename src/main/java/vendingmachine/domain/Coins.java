package vendingmachine.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class Coins {
	private static final int EMPTY = 0;
	private static final int QUANTITY = 1;

	private int coinBalance;
	private final Map<Coin, Integer> changeCoins = new LinkedHashMap<>();

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
}
