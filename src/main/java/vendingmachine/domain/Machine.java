package vendingmachine.domain;

import java.util.Map;
import java.util.SortedMap;

public class Machine {
	private final CoinStorage coinStorage = new CoinStorage();
	private final ItemStorage itemStorage = new ItemStorage();

	public void addCoins(SortedMap<Coin, Integer> coins) {
		coinStorage.addCoins(coins);
	}

	public void addItems(Map<String, Item> items) {
		itemStorage.addItems(items);
	}

	public SortedMap<Coin, Integer> getCoins() {
		return coinStorage.getCoins();
	}

	public void addInputCoinAmount(final int amount) {
		coinStorage.addInputCoinAmount(amount);
	}

	public int getInputCoinAmount() {
		return coinStorage.getInputCoinAmount();
	}

	public void purchase(String itemName) throws IllegalArgumentException {
		Item item = itemStorage.get(itemName);
		validatePurchase(item);
		coinStorage.decreaseInputCoinAmount(item.getPrice());
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
		SortedMap<Coin, Integer> returnCoins = coinStorage.returnCoins();
		coinStorage.decreaseInputCoinAmount(coinStorage.getToTalAmount(returnCoins));
		return returnCoins;
	}
}
