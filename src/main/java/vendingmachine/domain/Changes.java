package vendingmachine.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class Changes {
	private static final int COIN_COUNT_500_INDEX = 0;
	private static final int COIN_COUNT_100_INDEX = 1;
	private static final int COIN_COUNT_50_INDEX = 2;
	private static final int COIN_COUNT_10_INDEX = 3;

	private static LinkedHashMap<Coin, Integer> changeCoins = new LinkedHashMap<>();
	private static int inputMoney = 0;

	public LinkedHashMap<Coin, Integer> returnChange(LinkedHashMap<Coin, Integer> holdingCoins, int inputMoney) {
		for (Coin coin : Coin.values()) {
			int count = Math.min(holdingCoins.get(coin), inputMoney / coin.getAmount());
			changeCoins.put(coin, count);
			inputMoney -= coin.getAmount() * count;
		}
		return changeCoins;
	}
}
