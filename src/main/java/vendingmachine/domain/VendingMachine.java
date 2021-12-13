package vendingmachine.domain;

import static vendingmachine.utils.validator.ItemNameValidator.*;

import java.util.LinkedHashMap;
import java.util.Map;

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

	public void checkItem(String itemName, int amount) {
		validateItem(items, itemName, amount);
	}

	public int purchaseItem(String itemName, int amount) {
		return items.purchase(itemName, amount);
	}

	public Map<Coin, Integer> returnCoins(int amount) {
		Map<Coin, Integer> change = new LinkedHashMap<>();
		coins.processChange(change, amount);
		return change;
	}
}
