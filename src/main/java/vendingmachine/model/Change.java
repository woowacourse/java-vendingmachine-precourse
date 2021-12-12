package vendingmachine.model;

import static vendingmachine.constant.Constant.*;

import java.util.LinkedHashMap;
import java.util.Map;

public class Change {

	Map<Integer, Integer> coins = new LinkedHashMap<>();

	public Change() {
		coins.put(Coin.COIN_500.getAmount(), INITIAL_NUMBER);
		coins.put(Coin.COIN_100.getAmount(), INITIAL_NUMBER);
		coins.put(Coin.COIN_50.getAmount(), INITIAL_NUMBER);
		coins.put(Coin.COIN_10.getAmount(), INITIAL_NUMBER);
	}

	public void createGreedyCoin(PossessionCoin possessionCoin, int money) {
		for (int amount : Coin.createCoinList()) {
			coins.put(amount, Math.min(coins.get(amount) + money / amount, possessionCoin.getCoins().get(amount)));
			money -= amount * coins.get(amount);
		}
	}

	public Map<Integer, Integer> getCoins() {
		return coins;
	}
}
