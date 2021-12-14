package vendingmachine.model;

import static vendingmachine.constant.Constant.*;

import java.util.LinkedHashMap;
import java.util.Map;

public class Coins {

	Map<Integer, Integer> coins = new LinkedHashMap<>();

	public Coins() {
		coins.put(Coin.COIN_500.getAmount(), INITIAL_NUMBER);
		coins.put(Coin.COIN_100.getAmount(), INITIAL_NUMBER);
		coins.put(Coin.COIN_50.getAmount(), INITIAL_NUMBER);
		coins.put(Coin.COIN_10.getAmount(), INITIAL_NUMBER);
	}

	public Map<Integer, Integer> getCoins() {
		return coins;
	}
}
