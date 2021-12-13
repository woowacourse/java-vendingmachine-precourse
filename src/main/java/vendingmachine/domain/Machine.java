package vendingmachine.domain;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import vendingmachine.util.MapSupporter;

public class Machine {
	private final Map<Coin, Integer> coins = new HashMap<>();
	private int inputCoinAmount;
	private final Map<String, Item> items = new HashMap<>();

	public void addCoins(Map<Coin, Integer> coins) {
		for (Coin coin : coins.keySet()) {
			MapSupporter.increaseCoinCount(this.coins, coin, 0, coins.get(coin));
		}
	}

	public Map<Coin, Integer> getCoins() {
		return this.coins;
	}

	public void addInputCoinAmount(final int amount) {
		this.inputCoinAmount += amount;
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
		checkInputCoinAmountByItem(item);
		item.decreaseQuantity();
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
		if (inputCoinAmount < getMinPrice()) {
			return true;
		}
		return false;
	}

	public Map<Coin, Integer> returnCoins() {
		Map<Coin, Integer> returnCoins = new LinkedHashMap<>();
		int returnCoinsAmount = this.inputCoinAmount;
		for (Coin coin : coins.keySet()) {
			returnCoinsAmount = setReturnCoinsAndGetReturnCoinsAmount(returnCoins, returnCoinsAmount, coin);
		}
		return returnCoins;
	}

	private int setReturnCoinsAndGetReturnCoinsAmount(Map<Coin, Integer> returnCoins, int returnCoinsAmount,
		Coin coin) {
		// List였을땐 그냥 돌리면서 하면 됐는데 Map이라서 달라짐
		// for문을 개수로 돌리는데 개수가 변함.
		// -- 해결 --

		// 또 다른 문제 : LinkedHashMap으로 반환해야 view 편함
		// addCoins할때 sort할까?
		for (int i = 0; i < coins.get(coin); i++) {
			if (returnCoinsAmount < coin.getAmount()) {
				break;
			}
			MapSupporter.increaseCoinCount(returnCoins, coin, 0, 1);
			// MapSupporter.increaseCoinCount(coins, coin, 0, -1);
			returnCoinsAmount -= coin.getAmount();
		}
		return returnCoinsAmount;
	}
}
