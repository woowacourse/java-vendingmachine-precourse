package vendingmachine.domain;

import java.util.Map;
import java.util.SortedMap;

public class Machine {
	private final Wallet wallet = new Wallet();
	private int inputCoinAmount;
	private final ItemStorage itemStorage = new ItemStorage();

	public void addCoins(SortedMap<Coin, Integer> coins) {
		wallet.addCoins(coins);
	}

	public void addItems(Map<String, Item> items) {
		itemStorage.addItems(items);
	}

	public SortedMap<Coin, Integer> getCoins() {
		return wallet.getCoins();
	}

	public void addInputCoinAmount(final int amount) {
		this.inputCoinAmount += amount;
	}

	public int getInputCoinAmount() {
		return inputCoinAmount;
	}

	public void purchase(String itemName) throws IllegalArgumentException {
		Item item = itemStorage.get(itemName);
		validatePurchase(item);
		inputCoinAmount -= item.getPrice();
	}

	private void validatePurchase(Item item) {
		itemStorage.isNoItem(item);
		itemStorage.checkInputCoinAmountByItem(item, inputCoinAmount);
		item.decreaseQuantity();
	}

	public Boolean isPurchasable() {
		if (itemStorage.checkInputCoinAmountByMinPrice(inputCoinAmount))
			return false;
		return !itemStorage.isAllItemSoldOut();
	}

	public SortedMap<Coin, Integer> returnCoins() {
		SortedMap<Coin, Integer> returnCoins = wallet.returnCoins(inputCoinAmount);
		this.inputCoinAmount = wallet.getToTalAmount(returnCoins);
		return returnCoins;
	}
}
