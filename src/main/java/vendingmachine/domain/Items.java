package vendingmachine.domain;

import java.util.ArrayList;
import java.util.List;

public class Items {
	private final List<Item> itemList = new ArrayList<>();

	public void add(Item item) {
		itemList.add(item);
	}
}
