package vendingmachine.domain;

import static vendingmachine.resource.MessageResource.*;

import vendingmachine.utils.NumericUtils;

public class Money {
	private static final int MIN_PRICE = 0;

	private int currentAmount;

	public Money(String currentAmount) {
		this.currentAmount = NumericUtils.parsePositiveInt(currentAmount);
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
