package vendingmachine.controller;

import java.util.List;
import vendingmachine.model.CoinCase;
import vendingmachine.model.Product;
import vendingmachine.model.VendingMachine;
import vendingmachine.utils.CoinCaseFactory;
import vendingmachine.utils.ProductFactory;
import vendingmachine.utils.VendingMachineFactory;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {

	private VendingMachineController() {
	}

	public static void useVendingMachine() {
		VendingMachine vendingMachine = VendingMachineFactory
			.makeVendingMachine(putMoneyInVendingMachine(), putProductInVendingMachine(), putMoneyToVendingMachine());
		OutputView.printInsertedMoney(vendingMachine);
		InputView.writeProductNameToBuy(vendingMachine.getProducts());
	}

	private static List<CoinCase> putMoneyInVendingMachine() {
		int amount = InputView.writeVendingMachineAmount();
		return CoinCaseFactory.makeCoinsCase(amount);
	}

	private static List<Product> putProductInVendingMachine() {
		return ProductFactory.makeProducts();
	}

	private static int putMoneyToVendingMachine() {
		return InputView.writeInsertMoney();
	}
}
