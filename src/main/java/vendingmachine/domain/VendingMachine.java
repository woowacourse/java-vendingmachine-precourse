package vendingmachine.domain;

import static vendingmachine.constant.Constant.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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
		Optional<Item> it = salesItems.stream()
			.filter(item -> item.getName().equals(itemName))
			.filter(Item::isNotSoldOut)
			.findAny();
		if (!it.isPresent()) {
			throw new IllegalArgumentException(NO_STOCKS_MESSAGE);
		}
		coinStorage.changeCoins(money - it.get().getPrice());
		return money - it.get().getPrice();
	}

	public CoinStorage getCoinStorage() {
		return coinStorage;
	}

	public int getNeedMinimumMoney() {
		return salesItems.stream()
			.mapToInt(Item::getPrice)
			.min()
			.orElseThrow(NoSuchElementException::new);
	}
}
