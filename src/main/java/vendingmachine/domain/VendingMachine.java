package vendingmachine.domain;

import static vendingmachine.constant.Constant.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class VendingMachine {
	private final List<Item> salesItems = new ArrayList<>();
	private final CoinStorage coinStorage;

	public VendingMachine(int startMoney) {
		coinStorage = new CoinStorage(startMoney);
	}

	public void addNewItems(List<Item> items) {
		for (Item item : items) {
			isInItems(item);
			salesItems.add(item);
		}
	}

	private void isInItems(Item item) {
		if (salesItems.contains(item)) {
			throw new IllegalArgumentException(DUPLICATED_ITEM_MESSAGE);
		}
	}

	public int getItem(String itemName, int money) {
		Item itemPicked = salesItems.stream()
			.filter(item -> item.getName().equals(itemName))
			.filter(Item::isNotSoldOut)
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException(NO_ITEMS_MESSAGE));
		coinStorage.getChangeCoins(money - itemPicked.getPrice());
		itemPicked.sell();
		return money - itemPicked.getPrice();
	}

	public LinkedHashMap<Coin, Integer> getCoinStorageBox() {
		return coinStorage.checkbox();
	}

	public int getNeedMinimumMoney() {
		return salesItems.stream()
			.mapToInt(Item::getPrice)
			.min()
			.orElseThrow(() -> new IllegalArgumentException(NO_ITEMS_MESSAGE));
	}
}
