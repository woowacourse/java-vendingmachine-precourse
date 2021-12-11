package vendingmachine.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Items {
	private static final int INF = (int)2e9;

	private final List<Item> itemList = new ArrayList<>();

	public void add(Item item) {
		itemList.add(item);
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
}
