package vendingmachine.controller;

import static vendingmachine.view.InputView.*;


import vendingmachine.domain.VendingMachine;

public class VendingMachineController {
	private final VendingMachine vendingMachine;

	public VendingMachineController() {
		this.vendingMachine = new VendingMachine();
	}

	public void run() {
		printMessageToGetAmountMoneyOfVendingMachine();
		int inputMoney = inputTotalAmountMoneyOfVendingMachine();
		vendingMachine.createChanges(inputMoney);
	}
}
