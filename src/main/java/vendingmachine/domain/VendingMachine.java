package vendingmachine.domain;

import static vendingmachine.utils.validator.PurchaseItemValidator.*;

public class VendingMachine {

	private Coins coins;
	private Items items;

	public VendingMachine() {
		coins = new Coins();
		items = new Items();
	}

	public Coins getCoins() {
		return coins;
	}

	public void insertCoins(int amount) {
		coins.insertRandomCoins(amount);
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
		Item item = items.findByName(itemName);
		item.purchase();
		return item.getPrice();
	}
}
