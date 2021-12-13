package vendingmachine.domain;

import java.util.List;

import vendingmachine.util.Validator;

public class VendingMachine {
	private final Changes changes;
	private ItemList itemList;
	private int amount;

	public VendingMachine(int money) {
		changes = new Changes(money);
	}

	public void initItemList(List<Item> items) {
		itemList = new ItemList(items);
	}

	public void inputAmount(int inputAmount) {
		Validator.validateMoney(inputAmount);
		this.amount = inputAmount;
	}

	public boolean isAmountOverItemLeastPrice() {
		int leastItemPrice = itemList.getLeastItemPrice();
		return amount >= leastItemPrice;
	}

	public Changes getChanges() {
		return changes;
	}
}
