package vendingmachine.domain;

import java.util.Map;
import java.util.SortedMap;

public class Machine {
	private final Wallet wallet = new Wallet();
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
		wallet.addInputCoinAmount(amount);
	}

	public int getInputCoinAmount() {
		return wallet.getInputCoinAmount();
	}

	public void purchase(String itemName) throws IllegalArgumentException {
		Item item = itemStorage.get(itemName);
		validatePurchase(item);
		wallet.decreaseInputCoinAmount(item.getPrice());
	}

	private void validatePurchase(Item item) {
		itemStorage.isNoItem(item);
		itemStorage.checkInputCoinAmountByItem(item, getInputCoinAmount());
		item.decreaseQuantity();
	}

	public Boolean isPurchasable() {
		if (itemStorage.checkInputCoinAmountByMinPrice(getInputCoinAmount()))
			return false;
		return !itemStorage.isAllItemSoldOut();
	}

	public SortedMap<Coin, Integer> returnCoins() {
		SortedMap<Coin, Integer> returnCoins = wallet.returnCoins();
		wallet.decreaseInputCoinAmount(wallet.getToTalAmount(returnCoins));
		return returnCoins;
	}
}
