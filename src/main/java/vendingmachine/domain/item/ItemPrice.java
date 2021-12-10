package vendingmachine.domain.item;

import java.util.Objects;

import vendingmachine.validator.ItemValidator;

public class ItemPrice {
	private final int price;

	private ItemPrice(int price) {
		this.price = price;
	}

	public static ItemPrice from(String price) {
		ItemValidator.validateItemPrice(price);

		int parsedNumber = Integer.parseInt(price);
		return new ItemPrice(parsedNumber);
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}
		if (object == null || getClass() != object.getClass()) {
			return false;
		}
		ItemPrice itemPrice = (ItemPrice)object;
		return price == itemPrice.price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(price);
	}

	@Override
	public String toString() {
		return Integer.toString(this.price);
	}
}
