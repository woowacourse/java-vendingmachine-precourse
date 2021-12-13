package vendingmachine;

import vendingmachine.controller.CatalogController;
import vendingmachine.controller.ChangeController;
import vendingmachine.controller.PurchaseController;
import vendingmachine.controller.UserAccountController;
import vendingmachine.controller.VendingMachineAccountController;

public class Application {

	public static void main(String[] args) {
		// TODO: 프로그램 구현
		initApplication();
		startApplication();
		endApplication();
	}

	private static void startApplication() {
		PurchaseController.purchaseCatalogs();
	}

	private static void endApplication() {
		ChangeController.setChange();
		ChangeController.printChange();
	}

	private static void initApplication() {
		VendingMachineAccountController.setVendingMachineAccount();
		CatalogController.setCatalogListInput();
		UserAccountController.setUserAccountByInput();
	}
}
