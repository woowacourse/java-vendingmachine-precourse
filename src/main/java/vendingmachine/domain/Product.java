package vendingmachine.domain;

import java.util.List;
import java.util.Objects;

public class Product {
	private String name;
	private int price;
	private int amount;

	public Product(List<String> productInfo) {
		this.name = productInfo.get(ProductIdx.NAME.ordinal());
		this.price = Integer.parseInt(productInfo.get(ProductIdx.PRICE.ordinal()));
		this.amount = Integer.parseInt(productInfo.get(ProductIdx.AMOUNT.ordinal()));
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

	private enum ProductIdx {NAME, PRICE, AMOUNT}
}
