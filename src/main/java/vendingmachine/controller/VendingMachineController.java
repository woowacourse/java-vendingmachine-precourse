package vendingmachine.controller;

import vendingmachine.model.VendingMachine;
import vendingmachine.utils.CoinCaseFactory;
import vendingmachine.utils.ProductFactory;
import vendingmachine.utils.VendingMachineFactory;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {

	private VendingMachineController() {
	}

	public static void controlVendingMachine() {
		runVendingMachine(initVendingMachine());
	}

	private static VendingMachine initVendingMachine() {
		int amount = InputView.writeVendingMachineAmount();
		return VendingMachineFactory.makeVendingMachine(
			CoinCaseFactory.makeCoinsCase(amount),
			ProductFactory.makeProducts(),
			InputView.writeInsertMoney());
	}

	private static void runVendingMachine(VendingMachine vendingMachine) {
		OutputView.printInsertedMoney(vendingMachine);
		InputView.writeProductNameToBuy(vendingMachine.getProducts());
	}
}