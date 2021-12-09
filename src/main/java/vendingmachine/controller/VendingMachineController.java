package vendingmachine.controller;

import vendingmachine.view.InputView;

public class VendingMachineController {

	private VendingMachineController() {
	}

	public static void useVendingMachine() {
		InputView.writeVendingMachineAmount();
	}
}
