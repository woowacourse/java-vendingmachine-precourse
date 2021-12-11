package vendingmachine.controller;

import vendingmachine.service.VendingMachineAccountService;
import vendingmachine.view.VendingMachineAccountView;

public class VendingMachineAccountController {

	public static void setAccountInput() {
		VendingMachineAccountView.printInputGuide();
		VendingMachineAccountService.setAccountByInput();
	}

	public static void setRandomCoins() {
		VendingMachineAccountService.setRandomCoins();
	}

	public static void printCoinCount() {
		VendingMachineAccountView.printCoinList();
	}
}
