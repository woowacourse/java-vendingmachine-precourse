package vendingmachine.controller;

import vendingmachine.domain.Coins;
import vendingmachine.domain.Products;
import vendingmachine.domain.VendingMachine;
import vendingmachine.utils.RandomGenerator;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {

	public static void run() {
		Coins coins = new Coins(
			RandomGenerator.getHoldingCoin((InputView.getHoldingAmount()))
		);
		OutputView.printHoldingCoin(coins.getHoldingCoin());
		Products products = InputView.getProducts();
		VendingMachine vendingMachine = new VendingMachine(InputView.getEnteredAmount());
		OutputView.printEnteredAmount(vendingMachine.getEnteredAmount());

		while (isBuy(vendingMachine, products)) {
			buy();
		}
	}

	public static boolean isBuy(VendingMachine vendingMachine, Products products) {
		if (vendingMachine.isBuy(products.getLowestPossibleProductPrice())) {
			return true;
		}
		if (products.isBuy()) {
			return true;
		}
		return false;
	}

	public static void buy() {

	}
}
