package vendingmachine.controller;

import vendingmachine.domain.coin.Coins;
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
}
