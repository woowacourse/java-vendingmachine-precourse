package vendingmachine.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;

public class Machine {
	private final Wallet wallet = new Wallet();
	private int inputCoinAmount;
	private final Map<String, Item> items = new HashMap<>();

	public void addCoins(SortedMap<Coin, Integer> coins) {
		wallet.addCoins(coins);
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

	public void addItems(Map<String, Item> items) {
		for (String itemName : items.keySet()) {
			Item item = items.get(itemName);
			this.items.put(itemName, item);
		}
	}

	private int getMinPrice() {
		int itemMinPrice = Integer.MAX_VALUE;
		for (String itemName : items.keySet()) {
			Item item = items.get(itemName);
			if (!item.isSoldOut() && item.getPrice() < itemMinPrice) {
				itemMinPrice = item.getPrice();
			}
		}
		return itemMinPrice;
	}

	public void purchase(String itemName) throws IllegalArgumentException {
		Item item = items.get(itemName);
		validatePurchase(item);
		inputCoinAmount -= item.getPrice();
	}

	private void validatePurchase(Item item) {
		isNoItem(item);
		checkInputCoinAmountByItem(item);
		item.decreaseQuantity();
	}

	private void isNoItem(Item item) {
		if (item == null) {
			throw new IllegalArgumentException("[ERROR] 해당하는 상품이 없습니다.");
		}
	}

	private void checkInputCoinAmountByItem(Item item) {
		if (inputCoinAmount < item.getPrice()) {
			throw new IllegalArgumentException("[ERROR] 투입금액이 부족합니다.");
		}
	}

	public Boolean isPurchasable() {
		if (checkInputCoinAmountByMinPrice())
			return false;
		return !isAllItemSoldOut();
	}

	private Boolean isAllItemSoldOut() {
		for (String itemName : items.keySet()) {
			if (!items.get(itemName).isSoldOut()) {
				return false;
			}
		}
		return true;
	}

	private boolean checkInputCoinAmountByMinPrice() {
		return inputCoinAmount < getMinPrice();
	}

	public SortedMap<Coin, Integer> returnCoins() {
		SortedMap<Coin, Integer> returnCoins = wallet.returnCoins(inputCoinAmount);
		this.inputCoinAmount = wallet.getToTalAmount(returnCoins);
		return returnCoins;
	}
}
