package vendingmachine;

import vendingmachine.controller.VendingMachineController;

public class Application {
	private static final VendingMachineController vendingMachineController = new VendingMachineController();

	public static void main(String[] args) {
		initializeVendingMachine();
		useVendingMachine();
		returnCharge();
	}

	private static void initializeVendingMachine() {
		vendingMachineController.setVendingMachineCoinCounter();
		vendingMachineController.setProducts();
	}

	private static void useVendingMachine() {
		vendingMachineController.getUserAmount();
		vendingMachineController.useVendingMachine();
	}

	private static void returnCharge() {
		vendingMachineController.returnChange();
	}
}
