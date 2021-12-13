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
		VendingMachine vendingMachine = initVendingMachine();
		while (!vendingMachine.isReturnChangeCondition()) {
			runVendingMachine(vendingMachine);
		}
		OutputView.printInsertedMoney(vendingMachine);
		OutputView.printChanges(vendingMachine.returnChanges());
	}

	private static VendingMachine initVendingMachine() {
		int amount = InputView.writeVendingMachineAmount();
		return VendingMachineFactory.makeVendingMachine(
			CoinCaseFactory.makeCoinCase(amount),
			ProductFactory.makeProducts(),
			InputView.writeInsertMoney());
	}

	private static void runVendingMachine(VendingMachine vendingMachine) {
		String selectedProduct = InputView.writeProductNameToBuy(vendingMachine);
		vendingMachine.readyToSellProduct(selectedProduct);
	}
}
