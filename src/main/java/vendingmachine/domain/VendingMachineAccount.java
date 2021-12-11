package vendingmachine.domain;

import java.util.Map;

import vendingmachine.service.VendingMachineAccountService;

public class VendingMachineAccount {
	private static Map<Coin, Integer> coinCount;
	private static int account;

	public VendingMachineAccount(int account) {
		this.account = account;
		coinCount = VendingMachineAccountService.setRandomCoins(account);
	}

}
