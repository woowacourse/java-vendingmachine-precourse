package vendingmachine.controller;

import vendingmachine.model.CoinModel;
import vendingmachine.model.InputMoneyModel;
import vendingmachine.view.CoinView;

public class CoinController {
	public void makeChangeCoins() {
		InputMoneyModel.makeCoinFromInputMoney();
		displayCoinViews();
	}

	private void displayCoinViews() {
		CoinView.messagePrintCoins();
		CoinView.printCoins(CoinModel.getChangeCoins());
	}
}
