package vendingmachine.controller;

import vendingmachine.domain.Products;
import vendingmachine.domain.VendingMachine;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {
	public void run() {
		int inputVendingMachineMoney = inputVendingMachineMoney();
		VendingMachine vendingMachine = new VendingMachine(inputVendingMachineMoney);
		OutputView.printVendingMachineCoins(vendingMachine.findCoins());
		Products products = inputProduct();
		vendingMachine.addProducts(products);
	}

	private Products inputProduct() {
		try {
			OutputView.printInputProduct();
			return InputView.inputProduct();
		} catch (IllegalArgumentException exception) {
			OutputView.printException(exception);
			return inputProduct();
		}
	}

	private int inputVendingMachineMoney() {
		try {
			OutputView.printInputVendingMachineCoin();
			return InputView.inputVendingMachineMoney();
		} catch (IllegalArgumentException exception) {
			OutputView.printException(exception);
			return inputVendingMachineMoney();
		}
	}
}
