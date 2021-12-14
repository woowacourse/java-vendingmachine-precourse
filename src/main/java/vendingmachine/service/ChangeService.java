package vendingmachine.service;

import vendingmachine.domain.Coin;
import vendingmachine.repository.Change;
import vendingmachine.repository.UserAccount;
import vendingmachine.repository.VendingMachineAccount;

public class ChangeService {
	public static void calculateChange() {
		for (Coin coin : Coin.values()) {
			int maxCoinCount = UserAccount.divideByCoinUnit(coin);
			int possibleCoinCount = VendingMachineAccount.getPossibleCoinCount(coin, maxCoinCount);
			UserAccount.subtract(coin.getAmount() * possibleCoinCount);
			if (possibleCoinCount != 0) {
				Change.join(coin, possibleCoinCount);
			}
		}
	}
}
