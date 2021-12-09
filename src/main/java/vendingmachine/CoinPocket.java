package vendingmachine;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class CoinPocket {
	public Map<Coin, Integer> randomCoins;

	public CoinPocket() {
		randomCoins = new LinkedHashMap<>();
		Arrays.asList(Coin.values()).forEach(coin -> randomCoins.put(coin, 0));
	}

	public void push(Coin coin) {
		int previousNumber = randomCoins.get(coin);
		randomCoins.put(coin, previousNumber + 1);
	}

}
