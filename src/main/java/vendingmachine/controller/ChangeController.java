package vendingmachine.controller;

import java.util.HashMap;
import java.util.Map;

import vendingmachine.domain.Coin;
import vendingmachine.domain.UserAccount;
import vendingmachine.domain.VendingMachineAccount;
import vendingmachine.view.VendingMachineAccountView;

public class ChangeController {
	public static void setAndPrintChange() {
		int account = UserAccount.getAccount();
		Map<Coin, Integer> allCoinCount = VendingMachineAccount.getAllCoinCount();
		Map<Coin, Integer> changeCoinCount = new HashMap<>();
		for (Coin coin : allCoinCount.keySet()) {
			int coinValue = coin.getAmount();
			int coinCount = allCoinCount.get(coin);
			int maxCoinCountPossible = account / coinValue;
			if (coinCount < maxCoinCountPossible) {
				maxCoinCountPossible = coinCount;
			}
			if (maxCoinCountPossible != 0) {
				changeCoinCount.put(coin, maxCoinCountPossible);
			}
			account -= coinValue * maxCoinCountPossible;
		}
		System.out.println("잔돈");
		VendingMachineAccountView.printCoinMap(changeCoinCount);
	}
}
