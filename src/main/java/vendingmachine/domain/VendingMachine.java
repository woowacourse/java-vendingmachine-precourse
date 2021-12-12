package vendingmachine.domain;

import vendingmachine.views.OutputView;

public class VendingMachine {
	private Coins coins;
	private Items items;
	private Money money;

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

	public void insertMoney(String moneyString) {
		this.money = new Money(moneyString);
	}

	public void printMoney() {
		OutputView.printMoney(money);
	}
}
