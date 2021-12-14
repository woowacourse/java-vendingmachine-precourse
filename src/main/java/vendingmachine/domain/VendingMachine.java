package vendingmachine.domain;

import java.util.List;

import vendingmachine.constant.ErrorConst;
import vendingmachine.util.Validator;

public class VendingMachine {
	private final Changes changes;
	private ItemList itemList;
	private int amount;

	public VendingMachine(int money) {
		changes = new Changes();
		changes.makeRandomCoin(money);
	}

	public void initItemList(List<Item> items) {
		itemList = new ItemList(items);
	}

	public void inputAmount(int inputAmount) {
		Validator.validateMoney(inputAmount);
		this.amount = inputAmount;
	}

	public boolean haveAffordableItem() {
		return itemList.haveAffordableItem(amount);
	}

	public Changes getChanges() {
		return changes;
	}

	public int getAmount() {
		return amount;
	}

	public void buy(String itemName) {
		Item item = itemList.getItem(itemName);

		checkCanBuy(item);
		doPayment(item);
	}

	private void checkCanBuy(Item item) {
		if (!item.canBuy(amount)) {
			throw new IllegalArgumentException(ErrorConst.HAVE_NO_AFFORDABLE_MONEY);
		}
		if (!item.isRemain()) {
			throw new IllegalArgumentException(ErrorConst.HAVE_NO_STOCK);
		}
	}

	// 반드시 checkCanBuy 이후에 실행해야한다.
	private void doPayment(Item item) {
		item.sell();
		amount -= item.getPrice();
	}

	public Changes returnChange() {
		if (amount >= changes.getTotalAmount()) {
			return changes;
		}
		return changes.returnChange(amount);
	}
}
