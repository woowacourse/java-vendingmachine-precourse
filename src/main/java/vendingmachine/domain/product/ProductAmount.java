package vendingmachine.domain.product;

import vendingmachine.validator.AmountValidator;

public class ProductAmount {
	private final int amount;

	public ProductAmount(int amount) {
		AmountValidator.checkProductAmount(amount);
		this.amount = amount;
	}
}
