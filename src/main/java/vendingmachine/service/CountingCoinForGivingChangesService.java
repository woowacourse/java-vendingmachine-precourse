package vendingmachine.service;

import vendingmachine.model.Coin;

public class CountingCoinForGivingChangesService {
	public static int countCoinForChanges(int maxCoinNum, Coin coin, int remainMoney) {
		int givingCoin = remainMoney / coin.getAmount();

		if (givingCoin > maxCoinNum) {
			givingCoin = maxCoinNum;
		}

		return givingCoin;
	}
}
