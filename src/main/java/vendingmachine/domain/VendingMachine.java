package vendingmachine.domain;

import java.util.List;
import java.util.Map;

public class VendingMachine {
	public static final int NO_PRICE = 0;
	private final Map<Coin, Integer> balanceMap;
	private final List<Item> itemList;

	private VendingMachine(Map<Coin, Integer> balanceMap, List<Item> itemList) {
		this.balanceMap = balanceMap;
		this.itemList = itemList;
	}

	public static VendingMachine create(Map<Coin, Integer> balanceMap, List<Item> itemList) {
		return new VendingMachine(balanceMap, itemList);
	}

	public Map<Coin, Integer> getBalanceMap() {
		return this.balanceMap;
	}

	public List<Item> getItemList() {
		return this.itemList;
	}

	public int getMinPrice() {
		return this.itemList.stream()
			.mapToInt(Item::getPrice)
			.min()
			.orElse(NO_PRICE);
	}
}
