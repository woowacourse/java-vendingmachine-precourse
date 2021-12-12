package vendingmachine.controller;

import vendingmachine.domain.Coins;
import vendingmachine.domain.Product;
import vendingmachine.domain.Products;
import vendingmachine.domain.VendingMachine;
import vendingmachine.utils.RandomGenerator;
import vendingmachine.utils.ReturnCoin;
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

		do {
			buy(vendingMachine, products);
		} while (isBuy(vendingMachine, products));
		OutputView.printEnteredAmount(vendingMachine.getEnteredAmount());
		OutputView.printReturnCoin(ReturnCoin.getReturnCoin(coins.getHoldingCoin(), vendingMachine.getEnteredAmount()));
	}

	public static void buy(VendingMachine vendingMachine, Products products) {
		OutputView.printEnteredAmount(vendingMachine.getEnteredAmount());
		Product product = InputView.getProductToBuy(products, vendingMachine.getEnteredAmount());
		product.buy();
		vendingMachine.buy(product.getAmount());
	}

	public static boolean isBuy(VendingMachine vendingMachine, Products products) {
		if (!vendingMachine.isBuy(products.getLowestPossibleProductPrice())) {
			return false;
		}
		return !products.isEmpty();
	}
}
