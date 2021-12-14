package vendingmachine.service;

import java.util.Map;

import vendingmachine.domain.Coin;
import vendingmachine.repository.Change;
import vendingmachine.repository.UserAccount;
import vendingmachine.repository.VendingMachineAccount;

public class ChangeService {

	public static void calculateChange() {
		int account = UserAccount.getAccount();
		Map<Coin, Integer> allCoinCount = VendingMachineAccount.getAllCoinCount();

		for (Coin coin : Coin.values()) {
			int maxCoin = calculateMaxCoin(coin, allCoinCount, account);
			int coinValue = coin.getAmount();
			account -= coinValue * maxCoin;
		}
	}

	private static int calculateMaxCoin(Coin coin,
		Map<Coin, Integer> allCoinCount, int account) {

		int coinCount = allCoinCount.get(coin);
		int coinValue = coin.getAmount();
		int maxCoinCountPossible = account / coinValue;
		if (coinCount < maxCoinCountPossible) {
			maxCoinCountPossible = coinCount;
		}
		if (maxCoinCountPossible != 0) {
			Change.setChange(coin, maxCoinCountPossible);
		}
		return maxCoinCountPossible;
	}
}
