package vendingmachine.domain;

import java.util.List;

import vendingmachine.util.Validator;

public class VendingMachine {
	private final Changes changes;
	private ItemList itemList;
	private int inputAmount;

	public VendingMachine(int money) {
		changes = new Changes(money);
	}

	public void initItemList(List<Item> items) {
		itemList = new ItemList(items);
	}

	public void initInputAmount(int inputAmount) {
		Validator.validateMoney(inputAmount);
		this.inputAmount = inputAmount;
	}

	public Changes getChanges() {
		return changes;
	}
}
