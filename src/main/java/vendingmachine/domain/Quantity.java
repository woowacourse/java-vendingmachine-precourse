package vendingmachine.domain;

import static vendingmachine.enums.ErrorMessage.*;

public class Quantity {
	private int quantity;

	public Quantity(String value) {
		validateNumberFormat(value);
		int quantity = Integer.parseInt(value);
		validateRange(quantity);
		this.quantity = quantity;
	}

	public int get() {
		return quantity;
	}

	public void add(int quantity) {
		this.quantity += quantity;
	}

	private void validateNumberFormat(String value) {
		try {
			Integer.parseInt(value);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(QUANTITY_NOT_NUMBER_ERROR_MESSAGE.get());
		}
	}

	private void validateRange(int quantity) {
		if (quantity < 0) {
			throw new IllegalArgumentException(QUANTITY_LOWER_THEN_ZERO_ERROR_MESSAGE.get());
		}
	}
}
