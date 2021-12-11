package vendingmachine.domain;

import vendingmachine.views.OutputView;

public class VendingMachine {
	private Coins coins;

	public void inputChanges(Money changes) {
		createCoins(changes.getAmount());
	}

	private void createCoins(int changes) {
		coins = new Coins(changes);
	}

	public void printCoins() {
		OutputView.printCoins(coins);
	}
}
