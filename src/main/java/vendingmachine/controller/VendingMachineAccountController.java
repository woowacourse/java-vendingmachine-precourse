package vendingmachine.controller;

import vendingmachine.repository.VendingMachineAccount;
import vendingmachine.service.VendingMachineAccountService;
import vendingmachine.view.CoinView;
import vendingmachine.view.VendingMachineAccountView;

public class VendingMachineAccountController {

	public static void setVendingMachineAccount() {
		setAccountInput();
		setRandomCoins();
		printCoinCount();
	}

	public static void setAccountInput() {
		VendingMachineAccountView.printInputGuide();
		VendingMachineAccountService.setAccountByInput();
	}

	public static void setRandomCoins() {
		VendingMachineAccountService.setRandomCoins();
	}

	public static void printCoinCount() {
		VendingMachineAccountView.printVendingMachineCoin();
		CoinView.printCoinMap(VendingMachineAccount.getAllCoinCount());
	}
}
