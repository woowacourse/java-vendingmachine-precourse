package vendingmachine.domain;

import java.util.List;

public class Products {
	private final List<Product> products;

	public Products(List<Product> products) {
		this.products = products;
	}

	public int getLowestPossibleProductPrice() {
		return products.stream()
			.filter(Product::isBuy)
			.mapToInt(Product::getAmount)
			.min()
			.orElse(0);
	}

	public boolean isBuy() {
		return products.stream()
			.filter(Product::isBuy)
			.count() != 0L;
	}

}
