package vendingmachine.domain;

import java.util.List;

public class VendingMachine {
	private final Changes changes;
	private ItemList itemList;

	public VendingMachine(int money) {
		changes = new Changes(money);
	}

	public void initItemList(List<Item> items) {
		itemList = new ItemList(items);
	}

	public Changes getChanges() {
		return changes;
	}
}
