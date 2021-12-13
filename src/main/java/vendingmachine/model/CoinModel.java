package vendingmachine.model;

import java.util.Map;

import vendingmachine.domain.ChangeCoins;
import vendingmachine.domain.Coin;

public class CoinModel {
	private static ChangeCoins changeCoins;

	public static void makeChangeCoins(long money) {
		changeCoins = new ChangeCoins(money);
	}

	public static Map<Coin, Integer> getAllChangeCoins() {
		return changeCoins.getCoins();
	}

	public static Map<Coin, Integer> exchangeCoinFromMoney(long money) {
		return changeCoins.getChangeCoinsFromMoney(money);
	}
}
