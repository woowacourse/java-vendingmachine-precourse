package vendingmachine;

import vendingmachine.controller.VendingMachineController;

public class Application {
	public static void main(String[] args) {
		VendingMachineController vendingMachineController = new VendingMachineController();
		vendingMachineController.setVendingMachineCoinCounter();
		vendingMachineController.setProducts();
		vendingMachineController.getUserAmount();
		vendingMachineController.useVendingMachine();
		vendingMachineController.returnChange();
	}
}
