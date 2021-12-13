package vendingmachine.controller;

import vendingmachine.domain.coin.Coins;
import vendingmachine.domain.machine.Balance;
import vendingmachine.domain.product.Products;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {

	private Coins registerCoins() {
		try {
			final Coins coins = Coins.from(InputView.getInputCoins());
			OutputView.printLineSeparator();
			return coins;
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e);
			return registerCoins();
		}
	}

	private Products registerProducts() {
		try {
			final Products products = Products.from(InputView.getInputProducts());
			OutputView.printLineSeparator();
			return products;
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e);
			return registerProducts();
		}
	}

	private Balance registerBalance() {
		try {
			final Balance balance = Balance.from(InputView.getInputBalance());
			OutputView.printLineSeparator();
			return balance;
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e);
			return registerBalance();
		}
	}
}
