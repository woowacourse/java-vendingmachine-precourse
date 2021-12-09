package vendingmachine.utils;

import vendingmachine.model.VendingMachine;
import vendingmachine.view.InputView;

public class VendingMachineFactory {

	private VendingMachineFactory() {
	}

	public static VendingMachine makeVendingMachine() {
		return new VendingMachine(InputView.writeVendingMachineAmount());
	}
}
