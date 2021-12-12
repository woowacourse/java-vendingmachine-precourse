package vendingmachine.domain;

import java.util.List;
import java.util.Map;

import vendingmachine.util.BalanceValidator;
import vendingmachine.util.ItemValidator;
import vendingmachine.util.PurchaseValidator;

public class VendingMachine {
	private static final int NAME = 0;
	private static final int PRICE = 1;
	private static final int QUANTITY = 2;

	private Coins coins;
	private Items items;
	private Balance balance;

	public void initializeCoins(String input) {
		int coinBalance = BalanceValidator.isValidBalance(input);
		this.coins = new Coins(coinBalance);
		coins.createRandomCoins();
	}

	public void initializeItems(String input) {
		this.items = new Items();
		List<String> itemsInfo = ItemValidator.isValidItems(input);
		for (String itemInfo : itemsInfo) {
			List<String> detail = ItemValidator.isValidItem(itemInfo);
			items.add(new Item(detail.get(NAME), detail.get(PRICE), detail.get(QUANTITY)));
		}
	}

	public void initializeBalance(String input) {
		int balance = BalanceValidator.isValidBalance(input);
		BalanceValidator.isEnoughBalance(balance, items);
		this.balance = new Balance(balance);
	}

	public boolean isAvailable() {
		return balance.canBuy(items.getExistingCheapest());
	}

	public void executePurchase(String itemName) {
		PurchaseValidator.isValidPurchase(itemName, items, balance);
		for (Item item : items.getItemList()) {
			returnItem(item, itemName);
		}
	}

	private void returnItem(Item item, String itemName) {
		if (item.is(itemName) && item.exists()) {
			item.reduceQuantity();
			balance.reduceBalance(item.getPrice());
		}
	}

	public Map<Coin, Integer> getCoins() {
		return coins.getCoins();
	}

	public Map<Coin, Integer> getChangeable() {
		return coins.getChangeableCoins(balance);
	}

	public int getBalance() {
		return balance.getBalance();
	}
}
