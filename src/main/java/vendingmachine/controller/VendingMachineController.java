package vendingmachine.controller;

import vendingmachine.model.VendingMachine;
import vendingmachine.utils.VendingMachineFactory;
import vendingmachine.view.OutputView;

public class VendingMachineController {

	private VendingMachineController() {
	}

	public static void useVendingMachine() {
		VendingMachine vendingMachine = VendingMachineFactory.makeVendingMachine();
		OutputView.printVendingMachineCoinStatus(vendingMachine.getCoinsCase());
	}
}
