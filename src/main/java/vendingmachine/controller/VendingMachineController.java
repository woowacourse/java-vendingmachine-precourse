package vendingmachine.controller;

import vendingmachine.domain.Coins;
import vendingmachine.domain.Items;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {
	private static final InputView inputView = new InputView();
	private static final CoinController coinController = new CoinController(inputView);
	private static final ItemController itemcontroller = new ItemController(inputView);

	public void run() {

		Coins coins = coinController.giveHoldingCoins();
		OutputView.printHoldingCoinStatus(coins.toString());

		Items items = itemcontroller.giveItems();
	}

}
