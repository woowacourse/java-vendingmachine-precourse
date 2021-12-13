package vendingmachine;

import utils.validator.IsNotBlank;

public class Product {
	private final String name;
	private final Amount price;

	public Product(String name, int price) {
		new IsNotBlank().run(new StringBuilder(name));

		this.name = name;
		this.price = new Amount(price);
	}

	public int getPrice() {
		return price.get();
	}

	@Override
	public String toString() {
		return this.name;
	}
}
