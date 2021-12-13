package vendingmachine.domain;

import static vendingmachine.resource.MessageResource.*;

public class VendingMachine {
	private static final int MIN_PRICE = 0;

	private int currentAmount;

	public VendingMachine(int currentAmount) {
		this.currentAmount = currentAmount;
	}

	public int getCurrentAmount() {
		return currentAmount;
	}

	public void deduct(int productPrice) {
		if (currentAmount - productPrice < MIN_PRICE) {
			throw new IllegalArgumentException(ERROR_AMOUNT_IS_NOT_POSITIVE_INT);
		}
		currentAmount -= productPrice;
	}
}
