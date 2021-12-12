package vendingmachine.controller;

import vendingmachine.domain.VendingMachine;
import vendingmachine.util.Validator;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {
	public void run() {
		VendingMachine vendingMachine = initVendingMachine();
		OutputView.printChanges(vendingMachine.getChanges());
	}

	private VendingMachine initVendingMachine() {
		try {
			OutputView.printInitMessage();
			int initialMoney = InputView.inputMoney();
			Validator.validateInitialMoney(initialMoney);
			return new VendingMachine(initialMoney);
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e.getMessage());
			return initVendingMachine();
		}
	}
}
