package vendingmachine.model;

import vendingmachine.domain.ChangeCoins;

public class CoinModel {
	private static ChangeCoins changeCoins;

	public static void makeChangeCoins(long money) {
		changeCoins = new ChangeCoins(money);
	}
}
