package vendingmachine.domain.repository;

import java.util.LinkedHashMap;
import java.util.Map;

import vendingmachine.domain.Coin;
import vendingmachine.util.PublicConst;

public class CoinRepository {
	private final Map<Coin, Integer> coins = new LinkedHashMap<Coin, Integer>() {
		{
			put(Coin.COIN_500, PublicConst.NOT_EXIST);
			put(Coin.COIN_100, PublicConst.NOT_EXIST);
			put(Coin.COIN_50, PublicConst.NOT_EXIST);
			put(Coin.COIN_10, PublicConst.NOT_EXIST);
		}
	};

	public void addCoin(Coin coin, Integer coinCount) {
		coins.put(coin, coins.get(coin) + coinCount);
	}

	public void deleteCoin(Coin coin, Integer coinCount) {
		coins.put(coin, coins.get(coin) - coinCount);
	}

	public Map<Coin, Integer> getCoins() {
		return coins;
	}
}
