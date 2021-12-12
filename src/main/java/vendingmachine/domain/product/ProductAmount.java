package vendingmachine.domain.product;

import vendingmachine.validator.AmountValidator;

public class ProductAmount {
	private final int amount;

	public ProductAmount(int amount) {
		AmountValidator.checkProductAmount(amount);
		this.amount = amount;
	}

	public boolean isExpensive(int userAmount) {
		return amount > userAmount;
	}

	public int getChange(int userAmount) {
		return userAmount - amount;
	}

	public int compareTo(ProductAmount other) {
		return this.amount - other.amount;
	}
}
