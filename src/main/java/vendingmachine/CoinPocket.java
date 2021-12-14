package vendingmachine;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class CoinPocket {
	private final Map<Coin, Integer> randomCoins;

	public CoinPocket() {
		randomCoins = new LinkedHashMap<>();
		Arrays.asList(Coin.values()).forEach(coin -> randomCoins.put(coin, 0));
	}

	public Set<Map.Entry<Coin, Integer>> getEntries() {
		return randomCoins.entrySet();
	}

	public void pushSingle(final Coin coin) {
		int previousNumber = randomCoins.get(coin);
		randomCoins.put(coin, previousNumber + 1);
	}

	public void push(final Coin coin, final int number) {
		int previousNumber = randomCoins.get(coin);
		randomCoins.put(coin, previousNumber + number);
	}

	public int pop(final Coin coin, final int number) {
		int numberOfCoinsToPop = Integer.min(randomCoins.get(coin), number);
		randomCoins.put(coin, randomCoins.get(coin) - numberOfCoinsToPop);
		return numberOfCoinsToPop;
	}

	public void removeCoinsOfZeroNumber() {
		for (Coin coin : Coin.values()) {
			randomCoins.remove(coin, 0);
		}
	}
}
