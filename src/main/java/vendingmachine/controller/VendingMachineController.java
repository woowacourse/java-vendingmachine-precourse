package vendingmachine.controller;

import vendingmachine.domain.VendingMachine;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {
	public void run() {
		OutputView.printInputVendingMachineCoin();
		int inputVendingMachineMoney = inputVendingMachineMoney();
		VendingMachine vendingMachine = new VendingMachine(inputVendingMachineMoney);
		OutputView.printVendingMachineCoins(vendingMachine.findCoins());
	}

	private int inputVendingMachineMoney() {
		try {
			return InputView.inputVendingMachineMoney();
		} catch (IllegalArgumentException exception) {
			return inputVendingMachineMoney();
		}
	}
}
