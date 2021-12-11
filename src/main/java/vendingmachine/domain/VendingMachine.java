package vendingmachine.domain;

import java.util.List;
import java.util.Map;

public class VendingMachine {
	public static final int NO_PRICE = 0;
	private final Map<Integer, Integer> balanceMap;
	private final List<Item> itemList;
	private int minPrice;

	private VendingMachine(Map<Integer, Integer> balanceMap, List<Item> itemList) {
		this.balanceMap = balanceMap;
		this.itemList = itemList;
		updateMinPrice();
	}

	public static VendingMachine create(Map<Integer, Integer> balanceMap, List<Item> itemList) {
		return new VendingMachine(balanceMap, itemList);
	}

	public void updateMinPrice() {
		this.minPrice = this.itemList.stream()
			.mapToInt(Item::getPrice)
			.min()
			.orElse(NO_PRICE);
	}

	public Map<Integer, Integer> getBalanceMap() {
		return this.balanceMap;
	}

	public List<Item> getItemList() {
		return this.itemList;
	}

	public int getMinPrice() {
		return this.minPrice;
	}
}
