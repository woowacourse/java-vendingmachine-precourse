package vendingmachine.service;

import vendingmachine.model.Coin;

public class GivingChangesService {
	public static int countCoinForChanges(int maxCoinNum, Coin coin, int totalChanges) {
		int givingCoin = totalChanges / coin.getAmount();

		if (givingCoin > maxCoinNum) {
			givingCoin = maxCoinNum;
		}

		return givingCoin;
	}
}
