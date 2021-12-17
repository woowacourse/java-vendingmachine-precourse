package vendingmachine.domain;

import static vendingmachine.constant.Constant.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;

public class VendingMachine {
	private final List<Item> salesItems = new ArrayList<>();
	private final CoinStorage coinStorage;

	public VendingMachine(int startMoney) {
		coinStorage = new CoinStorage(startMoney);
	}

	public void addNewItems(List<Item> items) {
		for (Item item : items) {
			isAlreadyInSalesItems(item);
			salesItems.add(item);
		}
	}

	private void isAlreadyInSalesItems(Item item) {
		Optional<Item> isInItem = salesItems.stream()
			.filter(saleItem -> saleItem.getName().equals(item.getName()))
			.findAny();
		if (isInItem.isPresent()) {
			salesItems.clear();
			throw new IllegalArgumentException(DUPLICATED_ITEM_MESSAGE);
		}
	}

	public int getItem(String itemName, int money) {
		Item itemPicked = salesItems.stream()
			.filter(item -> item.getName().equals(itemName))
			.filter(Item::isNotSoldOut)
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException(NO_ITEMS_MESSAGE));
		if (money < itemPicked.getPrice()) {
			return money;
		}
		coinStorage.getChangeCoins(money - itemPicked.getPrice());
		itemPicked.sell();
		return money - itemPicked.getPrice();
	}

	public boolean isAnySalesItem() {
		Optional<Item> salesItem = salesItems.stream()
			.filter(Item::isNotSoldOut)
			.findAny();
		return salesItem.isPresent();
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
