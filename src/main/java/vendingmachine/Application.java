package vendingmachine;

import vendingmachine.controller.CatalogController;
import vendingmachine.controller.VendingMachineInputController;
import vendingmachine.domain.VendingMachineAccount;

public class Application {

	private static VendingMachineAccount vendingMachineAccount;

	public static void main(String[] args) {
		// TODO: 프로그램 구현
		vendingMachineAccount = new VendingMachineAccount(VendingMachineInputController.getAccountInput());
		vendingMachineAccount.printCoinCount();
	}
}
