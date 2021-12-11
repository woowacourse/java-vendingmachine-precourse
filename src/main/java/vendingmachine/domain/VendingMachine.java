package vendingmachine.domain;

import static vendingmachine.utils.validator.PurchaseItemValidator.*;

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

	public Coins returnCoins(int amount) {
		Coins change = new Coins();
		processChange(change, amount);
		return change;
	}

	private void processChange(Coins change, int amount) {
		for (Map.Entry<Coin, Integer> entry : coins.getList().entrySet()) {
			Coin coin = entry.getKey();
			Integer count = entry.getValue();

			int coinCount = calculateCount(coin, count, amount);
			change.getList()
				.put(coin, coinCount);

			amount -= coin.getAmount() * coinCount;
		}
	}

	private int calculateCount(Coin coin, int count, int amount) {
		return Math.min(amount / coin.getAmount(), count);
	}
}
