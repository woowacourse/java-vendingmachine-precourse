package vendingmachine;

import vendingmachine.controller.VendingMachineAccountController;

public class Application {

	public static void main(String[] args) {
		// TODO: 프로그램 구현
		VendingMachineAccountController.setAccountInput();
		VendingMachineAccountController.setRandomCoins();
		VendingMachineAccountController.printCoinCount();
		// CatalogController.getCatalogListInput();
		// catalogRepository.printAll();
	}
}
