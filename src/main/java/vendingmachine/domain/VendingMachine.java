package vendingmachine.domain;

import vendingmachine.views.OutputView;

public class VendingMachine {
	private Coins coins;
	private Items items;

	public void insertChanges(Money changes) {
		createCoins(changes.getAmount());
	}

	private void createCoins(int changes) {
		coins = new Coins(changes);
	}

	public void printCoins() {
		OutputView.printCoins(coins);
	}

	public void insertItems(String itemsString) {
		this.items = new Items(itemsString);
	}
}
