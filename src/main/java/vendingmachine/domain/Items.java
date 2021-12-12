package vendingmachine.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Items {
	private static final int INF = (int)2e9;

	private final List<Item> itemList = new ArrayList<>();
	private final List<String> nameList = new ArrayList<>();

	public void add(Item item) {
		itemList.add(item);
		nameList.add(item.getName());
	}

	public int getExistingCheapest() {
		List<Integer> existingPriceList = new ArrayList<>(Collections.singletonList(INF));
		for (Item item : itemList) {
			if (item.exists()) {
				existingPriceList.add(item.getPrice());
			}
		}
		return Collections.min(existingPriceList);
	}

	public boolean noSuchItem(String itemName) {
		return !nameList.contains(itemName);
	}

	public boolean notEnoughItem(String itemName) {
		for (Item item : itemList) {
			if (item.is(itemName) && !item.exists()) {
				return true;
			}
		}
		return false;
	}

	public boolean notEnoughBalance(String itemName, Balance balance) {
		for (Item item : itemList) {
			if (item.is(itemName) && !balance.canBuy(item.getPrice())) {
				return true;
			}
		}
		return false;
	}

	public List<Item> getItemList() {
		return Collections.unmodifiableList(itemList);
	}
}
