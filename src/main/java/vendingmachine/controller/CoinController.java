package vendingmachine.controller;

import vendingmachine.model.CoinModel;
import vendingmachine.model.MoneyModel;
import vendingmachine.view.CoinView;
import vendingmachine.view.MoneyView;

public class CoinController {
	public void makeChangeCoins() {
		MoneyModel.makeCoinFromInputMoney();
		displayCoinViews();
	}

	private void displayCoinViews() {
		CoinView.messagePrintCoins();
		CoinView.printCoins(CoinModel.getAllChangeCoins());
	}

	public void displayChangeCoinViews() {
		MoneyView.printLastUserMoney(MoneyModel.getUserMoney());
		CoinView.messageChangeCoinView();
		CoinView.printCoins(CoinModel.exchangeCoinFromMoney(MoneyModel.getUserMoney()));
	}
}
