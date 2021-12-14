package vendingmachine;

import vendingmachine.controller.VendingMachineController;

public class Application {
	public static void main(String[] args) {
		VendingMachineController vendingMachine = new VendingMachineController();
		vendingMachine.addItemsWithException();
		vendingMachine.buyItemsWithException();
		vendingMachine.showVendingMachineCoins();
	}

}
