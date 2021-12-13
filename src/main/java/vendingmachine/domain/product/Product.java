package vendingmachine.domain.product;

import vendingmachine.constant.Notification;
import vendingmachine.domain.money.Money;
import vendingmachine.domain.quantity.Quantity;
import vendingmachine.exception.OutOfBoundException;

public class Product {
	private static final int MINIMUM_PRICE = 100;
	private final String name;
	private final Money price;
	private final Quantity stock;

	public Product(String name, Money price, Quantity quantity) {
		validateNameEmpty(name);
		validateMinimumPrice(price);
		this.name = name;
		this.price = price;
		this.stock = quantity;
	}

	public static Product of(String name, String price, String quantity) {
		return new Product(name, Money.of(price), Quantity.of(quantity));
	}

	private void validateMinimumPrice(Money price) {
		if (!price.isSpendable(MINIMUM_PRICE)) {
			throw new IllegalArgumentException(Notification.PRODUCT_INSUFFICIENCY_PRICE.getMessage());
		}
	}

	private void validateNameEmpty(String name) {
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException(Notification.PRODUCT_NAME_INVALID.getMessage());
		}
	}

	public String getName() {
		return name;
	}

	public void decreaseStock() {
		try {
			stock.down();
		} catch (OutOfBoundException e) {
			throw new IllegalArgumentException(Notification.PRODUCTS_STOCK_INSUFFICIENT.getMessage());
		}
	}

	public Money getPrice() {
		return Money.of(price.getAmount());
	}

	public boolean isPurchasable(Money money) {
		return !this.stock.isZero() && money.isSpendable(this.price);
	}
}
