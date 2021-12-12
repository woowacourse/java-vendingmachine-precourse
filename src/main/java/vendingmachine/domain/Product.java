package vendingmachine.domain;

import static vendingmachine.enums.ErrorMessage.*;

public class Product {
	private static final Money MINIMUM_PRICE = new Money("100");

	private Name name;
	private Money price;
	private Quantity quantity;

	public Product(Name name, Money price, Quantity quantity) {
		validateMinimumPrice(price);
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Product{" +
			"name=" + name +
			", price=" + price +
			", quantity=" + quantity +
			'}';
	}

	public boolean isSameName(Name name) {
		String productName = this.name.get();
		String checkProductName = name.get();
		return productName.equals(checkProductName);
	}

	private void validateMinimumPrice(Money price) {
		if (price.isLowerThen(MINIMUM_PRICE)) {
			throw new IllegalArgumentException(PRICE_LOWER_THEN_MINIMUM_PRICE_ERROR_MESSAGE.get());
		}
	}
}
