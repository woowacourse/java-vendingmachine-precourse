package vendingmachine.controller;

import vendingmachine.domain.VendingMachine;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {

	private final VendingMachine vendingMachine;

	public VendingMachineController() {
		OutputView.setVendingMachineMoney();
		vendingMachine = new VendingMachine(InputView.readLineInt());
	}
}