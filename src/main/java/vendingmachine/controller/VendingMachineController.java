package vendingmachine.controller;

import vendingmachine.domain.Money;
import vendingmachine.domain.VendingMachine;
import vendingmachine.views.InputView;
import vendingmachine.views.OutputView;

public class VendingMachineController {
	private VendingMachine vendingMachine;

	public VendingMachineController(VendingMachine vendingMachine) {
		this.vendingMachine = vendingMachine;
	}

	public void run() {
		insertChanges();
		vendingMachine.printCoins();
	}

	private void insertChanges() {
		try {
			String changesString = InputView.inputChanges();
			vendingMachine.inputChanges(new Money(changesString));
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			insertChanges();
		}
	}
}
