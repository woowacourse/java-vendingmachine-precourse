package vendingmachine.controller;

import vendingmachine.domain.Money;
import vendingmachine.domain.Products;
import vendingmachine.domain.VendingMachine;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {
	public void run() {
		VendingMachine vendingMachine = new VendingMachine(inputVendingMachineMoney());
		OutputView.printVendingMachineCoins(vendingMachine.findCoins());
		Products products = inputProduct();
		vendingMachine.addProducts(products);
		vendingMachine.inputMoney(inputMoney());
	}

	private Money inputMoney() {
		try {
			OutputView.printInputMoney();
			return InputView.inputMoney();
		} catch (IllegalArgumentException exception) {
			OutputView.printException(exception);
			return inputMoney();
		}
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

	private Money inputVendingMachineMoney() {
		try {
			OutputView.printInputVendingMachineCoin();
			return InputView.inputVendingMachineMoney();
		} catch (IllegalArgumentException exception) {
			OutputView.printException(exception);
			return inputVendingMachineMoney();
		}
	}
}
