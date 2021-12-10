package vendingmachine.controller;

import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {
	public void run() {
		OutputView.printInputVendingMachineCoin();
		inputVendingMachineCoin();
	}

	private void inputVendingMachineCoin() {
		try {
			InputView.inputVendingMachineCoin();
		} catch (IllegalArgumentException exception) {
			inputVendingMachineCoin();
		}
	}
}
