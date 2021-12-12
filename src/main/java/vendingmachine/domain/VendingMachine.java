package vendingmachine.domain;

import static vendingmachine.utils.validator.ItemNameValidator.*;

public class VendingMachine {

	private final Coins coins;
	private final Items items;

	public VendingMachine() {
		coins = new Coins();
		items = new Items();
	}

	public Coins getCoins() {
		return coins;
	}

	public void insertCoins(int holdingAmount) {
		coins.insertRandomCoins(holdingAmount);
	}

	public void insertItems(String itemList) {
		items.insertItems(itemList);
	}

	public boolean availablePurchase(int amount) {
		return items.check(amount);
	}

	public void checkItem(String itemName) {
		validateItem(items, itemName);
	}

	public int purchaseItem(String itemName) {
		return items.purchase(itemName);
	}

	public Coins returnCoins(int amount) {
		Coins change = new Coins();
		change.processChange(coins, amount);
		return change;
	}
}
