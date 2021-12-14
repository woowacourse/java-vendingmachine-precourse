package vendingmachine.controller;

import vendingmachine.model.VendingMachine;
import vendingmachine.utils.VendingMachineFactory;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {

	private VendingMachineController() {
	}

	public static void controlVendingMachine() {
		VendingMachine vendingMachine = VendingMachineFactory.makeVendingMachine();
		while (!vendingMachine.isChangeCondition()) {
			runVendingMachine(vendingMachine);
		}
		OutputView.printInsertedMoney(vendingMachine);
		OutputView.printChanges(vendingMachine.returnChanges());
	}

	private static void runVendingMachine(VendingMachine vendingMachine) {
		String selectedProduct = InputView.writeProductNameToBuy(vendingMachine);
		vendingMachine.readyToSellProduct(selectedProduct);
	}
}
