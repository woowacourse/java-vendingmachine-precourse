package vendingmachine.controller;

import vendingmachine.domain.VendingMachine;
import vendingmachine.view.ResultView;

public class VendingMachineController {

	private final VendingMachine vendingMachine;

	public VendingMachineController(VendingMachine vendingMachine) {
		this.vendingMachine = vendingMachine;
	}

	public void run() {
		vendingMachine.createChange();
		ResultView.printVendingMachineCoin(vendingMachine);
		System.out.println();
		vendingMachine.createProducts();
		System.out.println();
		vendingMachine.insertMoney();
		System.out.println();
		ResultView.printInsertMoney(vendingMachine);
		vendingMachine.purchaseProduct();
		System.out.println();
		while (!vendingMachine.userInputMoneyUnderMinProductPrice()) {
			ResultView.printInsertMoney(vendingMachine);
			vendingMachine.purchaseProduct();
			System.out.println();
		}
		ResultView.printInsertMoney(vendingMachine);
		ResultView.printVendingMachineReturnChanges(vendingMachine);
	}
}
