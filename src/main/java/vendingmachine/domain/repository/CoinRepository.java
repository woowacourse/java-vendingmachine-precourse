package vendingmachine.domain.repository;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import vendingmachine.domain.Coin;

public class CoinRepository {
	private final Map<Coin, Integer> coins = new LinkedHashMap<Coin, Integer>() {
		{
			put(Coin.COIN_500, 0);
			put(Coin.COIN_100, 0);
			put(Coin.COIN_50, 0);
			put(Coin.COIN_10, 0);
		}
	};

	public void addCoin(Coin coin, Integer coinCount) {
		coins.put(coin, coins.get(coin) + 1);
	}

	public void deleteCoin(Coin coin, Integer coinCount) {
		coins.put(coin, coins.get(coin) - coinCount);
	}

	public Map<Coin, Integer> getCoins() {
		return coins;
	}
}
