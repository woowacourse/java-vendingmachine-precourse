package vendingmachine.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class Changes {

	private static Map<Coin, Integer> changeCoins = new LinkedHashMap<>();

	public Map<Coin, Integer> returnChange(LinkedHashMap<Coin, Integer> holdingCoins, int inputMoney) {
		for (Coin coin : Coin.values()) {
			int count = Math.min(holdingCoins.get(coin), inputMoney / coin.getAmount());
			changeCoins.put(coin, count);
			inputMoney -= coin.getAmount() * count;
		}
		return changeCoins;
	}
}
