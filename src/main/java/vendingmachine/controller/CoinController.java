package vendingmachine.controller;

import vendingmachine.model.CoinModel;
import vendingmachine.model.MoneyModel;
import vendingmachine.view.CoinView;

public class CoinController {
	public void makeChangeCoins() {
		MoneyModel.makeCoinFromInputMoney();
		displayCoinViews();
	}

	private void displayCoinViews() {
		CoinView.messagePrintCoins();
		CoinView.printCoins(CoinModel.getChangeCoins());
	}
}
