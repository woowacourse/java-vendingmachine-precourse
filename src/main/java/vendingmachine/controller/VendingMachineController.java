package vendingmachine.controller;

import vendingmachine.model.VendingMachine;
import vendingmachine.utils.VendingMachineFactory;

public class VendingMachineController {

	private VendingMachineController() {
	}

	public static void useVendingMachine() {
		VendingMachine vendingMachine = VendingMachineFactory.makeVendingMachine();
	}
}
