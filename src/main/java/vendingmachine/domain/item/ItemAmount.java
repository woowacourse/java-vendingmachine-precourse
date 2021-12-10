package vendingmachine.domain.item;

import java.util.Objects;

import vendingmachine.validator.ItemValidator;

public class ItemAmount {
	private final int amount;

	private ItemAmount(int amount) {
		this.amount = amount;
	}

	public static ItemAmount from(String amount) {
		ItemValidator.validateItemAmount(amount);

		int parsedNumber = Integer.parseInt(amount);
		return new ItemAmount(parsedNumber);
	}

	public int toInt() {
		return this.amount;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}
		if (object == null || getClass() != object.getClass()) {
			return false;
		}
		ItemAmount that = (ItemAmount)object;
		return amount == that.amount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount);
	}

	@Override
	public String toString() {
		return Integer.toString(this.amount);
	}
}
