package vendingmachine.domain.item;

import java.util.Objects;

import vendingmachine.validator.ItemValidator;

public class ItemQuantity {
	private final int itemQuantity;

	private ItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	public static ItemQuantity from(String itemQuantity) {
		ItemValidator.validateItemQuantity(itemQuantity);

		int parsedNumber = Integer.parseInt(itemQuantity);
		return new ItemQuantity(parsedNumber);
	}

	public ItemQuantity subtract() {
		ItemValidator.validateAbleToSubtractItemQuantity(this.itemQuantity);
		return new ItemQuantity(this.itemQuantity - 1);
	}

	public int toInt() {
		return this.itemQuantity;
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
		return Integer.toString(this.itemQuantity);
	}
}
