package vendingmachine.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import vendingmachine.util.supporter.MapSupporter;

public class Machine {
	private final SortedMap<Coin, Integer> coins = new TreeMap<>((c1, c2) -> c2.getAmount() - c1.getAmount());
	private int inputCoinAmount;
	private final Map<String, Item> items = new HashMap<>();

	public void addCoins(SortedMap<Coin, Integer> coins) {
		for (Coin coin : coins.keySet()) {
			MapSupporter.increaseCoinCount(this.coins, coin, 0, coins.get(coin));
		}
	}

	public SortedMap<Coin, Integer> getCoins() {
		return this.coins;
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
		SortedMap<Coin, Integer> returnCoins = new TreeMap<>((c1, c2) -> c2.getAmount() - c1.getAmount());
		int returnCoinsAmount = this.inputCoinAmount;
		for (Coin coin : coins.keySet()) {
			returnCoinsAmount = setReturnCoinsAndGetReturnCoinsAmount(returnCoins, returnCoinsAmount, coin);
		}
		this.inputCoinAmount = returnCoinsAmount;
		return returnCoins;
	}

	private int setReturnCoinsAndGetReturnCoinsAmount(SortedMap<Coin, Integer> returnCoins, int returnCoinsAmount,
		Coin coin) {
		for (int i = 0; i < coins.get(coin); i++) {
			if (returnCoinsAmount < coin.getAmount()) {
				break;
			}
			MapSupporter.increaseCoinCount(returnCoins, coin, 0, 1);
			returnCoinsAmount -= coin.getAmount();
		}
		return returnCoinsAmount;
	}
}
