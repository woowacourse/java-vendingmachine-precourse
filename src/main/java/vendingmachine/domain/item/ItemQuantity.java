package vendingmachine.domain.item;

import java.util.Objects;

import vendingmachine.validator.ItemValidator;

public class ItemQuantity {
	private static final int SUBTRACT_QUANTITY = 1;

	private final int itemQuantity;

	private ItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	public static ItemQuantity from(int itemQuantity) {
		ItemValidator.validateItemQuantity(itemQuantity);
		return new ItemQuantity(itemQuantity);
	}

	public ItemQuantity subtract() {
		ItemValidator.validateAbleToSubtractItemQuantity(itemQuantity);
		return new ItemQuantity(itemQuantity - SUBTRACT_QUANTITY);
	}

	public int toInt() {
		return itemQuantity;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}
		if (object == null || getClass() != object.getClass()) {
			return false;
		}
		ItemQuantity that = (ItemQuantity)object;
		return itemQuantity == that.itemQuantity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(itemQuantity);
	}

	@Override
	public String toString() {
		return Integer.toString(itemQuantity);
	}
}
