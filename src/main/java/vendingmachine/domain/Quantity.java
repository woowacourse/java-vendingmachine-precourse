package vendingmachine.domain;

import vendingmachine.utils.ErrorMessage;

public class Quantity {
	private int quantity;

	public Quantity(int quantity) {
		validateQuantity(quantity);
		this.quantity = quantity;
	}

	public void decreaseQuantity() {
		quantity--;
	}

	public boolean isQuantityZero() {
		return quantity == 0;
	}

	public static void validateQuantity(int quantity) {
		if (quantity < 0) {
			throw new IllegalArgumentException(ErrorMessage.INVALID_QUANTITY_ERROR_MESSAGE);
		}
	}
}
