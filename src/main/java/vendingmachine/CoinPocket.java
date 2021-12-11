package vendingmachine;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class CoinPocket {
	private static final int MINIMUM_NUMBER_OF_COINS = 0;
	private Map<Coin, Integer> randomCoins;

	public CoinPocket() {
		randomCoins = new LinkedHashMap<>();
		Arrays.asList(Coin.values()).forEach(coin -> randomCoins.put(coin, 0));
	}

	public Set<Map.Entry<Coin, Integer>> getEntries() {
		return randomCoins.entrySet();
	}

	public void push(Coin coin, int number) {
		int previousNumber = randomCoins.get(coin);
		randomCoins.put(coin, previousNumber + number);
	}

	public int pop(Coin coin, int number) {
		int numberOfCoinsToPop = Integer.min(randomCoins.get(coin), number);
		randomCoins.put(coin, numberOfCoinsToPop);
		return numberOfCoinsToPop;
	}

	public void removeZeros() {
		for (Coin coin : Coin.values()) {
			randomCoins.remove(coin, 0);
		}
	}
}
