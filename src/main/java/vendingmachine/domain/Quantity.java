package vendingmachine.domain;

import vendingmachine.utils.Validator;

public class Quantity {
	private int quantity;

	public Quantity(int quantity) {
		Validator.validateQuantity(quantity);
		this.quantity = quantity;
	}

	public void decreaseQuantity() {
		quantity--;
	}

	public boolean isQuantityZero() {
		return quantity == 0;
	}
}
