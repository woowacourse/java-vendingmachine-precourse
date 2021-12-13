package vendingmachine.controller.classes;

import java.util.HashMap;

import vendingmachine.controller.CoinGeneratorInterface;
import vendingmachine.model.Coin;

public class CoinGenerator implements CoinGeneratorInterface {
	@Override
	public HashMap<Coin, Integer> getRandomCoins(int price) {
		HashMap<Coin, Integer> coinMap = new HashMap<>();
		initCoinMap(coinMap);
		return coinMap;
	}

	private void initCoinMap(HashMap<Coin, Integer> coinMap) {
		coinMap.put(Coin.COIN_500, 0);
		coinMap.put(Coin.COIN_100, 0);
		coinMap.put(Coin.COIN_50, 0);
		coinMap.put(Coin.COIN_10, 0);
	}
}
