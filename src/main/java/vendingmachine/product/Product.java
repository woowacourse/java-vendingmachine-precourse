package vendingmachine.product;

import vendingmachine.Money;
import vendingmachine.Notification;
import vendingmachine.quantity.Quantity;

public class Product {
	private static final int MINIMUM_PRICE = 100;
	private final String name;
	private final Money price;
	private final Quantity quantity;

	public Product(String name, Money price, Quantity quantity) {
		validateNameEmpty(name);
		validateMinimumPrice(price);
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	private void validateMinimumPrice(Money price) {
		if(!price.isSpendable(MINIMUM_PRICE)) {
			throw new IllegalArgumentException(Notification.PRODUCT_INSUFFICIENCY_PRICE.getMessage());
		}
	}

	public static Product of(String name, String price, String quantity) {
		return new Product(name, Money.of(price), Quantity.of(quantity));
	}

	private void validateNameEmpty(String name) {
		if(name==null || name.isEmpty()) {
			throw new IllegalArgumentException(Notification.PRODUCT_NAME_INVALID.getMessage());
		}
	}

	public String getName() {
		return name;
	}

	// 필요없다면 최종에 제거하기
	public Money getPrice() {
		return price;
	}

	// 필요없다면 최종에 제거하기
	public Quantity getQuantity() {
		return quantity;
	}
}
