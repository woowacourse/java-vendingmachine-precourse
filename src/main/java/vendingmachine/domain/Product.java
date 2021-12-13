package vendingmachine.domain;

import java.util.Objects;

public class Product {
	private static final String FORMAT = "[%s, %s, %s]";
	public static final String NAME = "상품";

	private Name name;
	private Price price;
	private Quantity quantity;

	public Product(Name name, Price price, Quantity quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Product product = (Product)o;
		return Objects.equals(name, product.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public String toString() {
		return String.format(FORMAT, name.toString(), price.toString(), quantity.toString());
	}
}
