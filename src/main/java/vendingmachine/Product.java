package vendingmachine;

import utils.validator.isNotBlank;

public class Product {
	private final String name;
	private final Amount price;

	Product (String name, int price) {
		new isNotBlank().run(new StringBuilder(name));
		this.name = name;
		this.price = new Amount(price);
	}
}
