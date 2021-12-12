package vendingmachine.domain;

import java.util.List;
import java.util.Map;

import vendingmachine.view.ErrorMessage;

public class VendingMachine {
	private final Map<Coin, Integer> balanceMap;
	private final List<Item> itemList;

	private VendingMachine(Map<Coin, Integer> balanceMap, List<Item> itemList) {
		this.balanceMap = balanceMap;
		this.itemList = itemList;
	}

	public static VendingMachine create(Map<Coin, Integer> balanceMap, List<Item> itemList) {
		return new VendingMachine(balanceMap, itemList);
	}

	public int getMinPrice() {
		return this.itemList.stream()
			.mapToInt(Item::getPrice)
			.min()
			.orElseThrow(() -> new IllegalArgumentException(ErrorMessage.CANNOT_FIND_MINIMUM_ITEM_PRICE));
	}

	public Map<Coin, Integer> getBalanceMap() {
		return this.balanceMap;
	}

	public List<Item> getItemList() {
		return this.itemList;
	}
}
