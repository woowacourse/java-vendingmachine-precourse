package vendingmachine.controller;

import static constant.CharacterConstant.*;
import static constant.StringConstant.*;
import static vendingmachine.app.ObjectContainer.*;

import vendingmachine.view.InputView;
import vendingmachine.view.PrintView;

public class VendingMachineController {
	public void startVendingMachine() {
		String vendingMachineBalance = InputView.getVendingMachineBalance();
		saveBalance(vendingMachineBalance);
	}

	private void saveBalance(String balance) {
		try {
			vendingMachine.setBalance(balance);
			saveCoins();
		} catch (IllegalArgumentException e) {
			System.out.println(ERROR_PREFIX + BALANCE_PRICE_PREFIX + e.getMessage() + LINE_STAMP);
			startVendingMachine();
		}
	}

	private void saveCoins() {
		vendingMachine.setCoins();
		PrintView.printVendingMachineCoins(vendingMachine.getCoins());

		getProducts();
	}

	private void getProducts() {
		String userProducts = InputView.getVendingMachineProducts();
		saveProducts(userProducts);
	}

	private void saveProducts(String userProducts) {
		try {
			vendingMachine.setProductList(userProducts);

		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			getProducts();

		}
	}

}
