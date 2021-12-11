package vendingmachine.product;

import vendingmachine.Money;
import vendingmachine.Notification;
import vendingmachine.quantity.Quantity;

public class Product {
	private final String name;
	private final Money price;
	private final Quantity quantity;

	public Product(String name, Money price, Quantity quantity) {
		validateNameEmpty(name);
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public static Product of(String name, String price, String quantity) {
		return new Product(name, Money.of(price), Quantity.of(quantity));
	}

	private void validateNameEmpty(String name) {
		if(name==null || name.isEmpty()) {
			throw new IllegalArgumentException(Notification.PRODUCT_NAME_INVALID.getMessage());
		}
	}
}
