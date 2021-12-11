package vendingmachine.controller;

import vendingmachine.domain.Coins;
import vendingmachine.view.InputView;

public class VendingMachineController {
	private static final InputView inputView = new InputView();
	private static final CoinController coinController = new CoinController(inputView);

	public void run() {

		Coins coins = coinController.giveHoldingCoins();

	}

}
