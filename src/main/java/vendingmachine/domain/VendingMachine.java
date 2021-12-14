package vendingmachine.domain;

import java.util.EnumMap;

import vendingmachine.exception.RequestChangesException;
import vendingmachine.views.OutputView;

public class VendingMachine {
	private static final String CHANGES = "잔돈";

	private Coins coins;
	private Items items;
	private Money moneyLeft;

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
		this.moneyLeft = new Money(moneyString);
	}

	public void printMoney() {
		OutputView.printMoney(moneyLeft);
	}

	public void purchase(String itemName) {
		if (requestedChanges(itemName)) {
			throw new RequestChangesException();
		}
		int spendAmount = items.purchase(itemName, moneyLeft.getAmount());
		moneyLeft.spend(spendAmount);
	}

	public boolean continuable() {
		return items.continuable(moneyLeft.getAmount());
	}

	private boolean requestedChanges(String string) {
		return string.equals(CHANGES);
	}

	public void giveBackChanges() {
		EnumMap<Coin, Integer> changes = coins.changeCoins(moneyLeft.getAmount());
		OutputView.printChanges(changes);
	}
}
