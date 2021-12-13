package vendingmachine.domain;

import java.util.LinkedHashMap;

public class Changes {
	private static int inputMoney = 0;

	private static LinkedHashMap<Coin, Integer> changeCoins = new LinkedHashMap<>();

	public LinkedHashMap<Coin, Integer> returnChange(LinkedHashMap<Coin, Integer> holdingCoins, int inputMoney) {
		for (Coin coin : Coin.values()) {
			int count = Math.min(holdingCoins.get(coin), inputMoney / coin.getAmount());
			changeCoins.put(coin, count);
			inputMoney -= coin.getAmount() * count;
		}
		return changeCoins;
	}
}
