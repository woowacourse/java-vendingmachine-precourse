package vendingmachine.domain;

import java.util.List;
import java.util.Map;

import vendingmachine.Validation;

public class VendingMachine {
	private static final int NAME = 0;
	private static final int PRICE = 1;
	private static final int QUANTITY = 2;

	private Coins coins;
	private Items items;
	private Balance balance;

	public void initializeCoins(String input) {
		int coinBalance = Validation.isValidBalance(input);
		this.coins = new Coins(coinBalance);
		coins.createRandomCoins();
	}

	public void initializeItems(String input) {
		this.items = new Items();
		List<String> itemsInfo = Validation.isValidItems(input);
		for (String itemInfo : itemsInfo) {
			List<String> detail = Validation.isValidItem(itemInfo);
			items.add(new Item(detail.get(NAME), detail.get(PRICE), detail.get(QUANTITY)));
		}
	}

	public void initializeBalance(String input) {
		int balance = Validation.isValidBalance(input);
		this.balance = new Balance(balance);
	}

	public boolean isAvailable() {
		return balance.getBalance() >= items.getExistingCheapest();
	}

	public void executePurchase(String itemName) {
		Validation.isValidPurchase(itemName, items, balance);
		for (Item item : items.getItemList()) {
			returnItem(item, itemName);
		}
	}

	private void returnItem(Item item, String itemName) {
		if (item.getName().equals(itemName) && item.exists()) {
			item.reduceQuantity();
			balance.reduceBalance(item.getPrice());
		}
	}

	public Map<Coin, Integer> getCoins() {
		return coins.getCoins();
	}

	public int getBalance() {
		return balance.getBalance();
	}
}
