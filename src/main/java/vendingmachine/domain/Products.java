package vendingmachine.domain;

import java.util.List;
import java.util.Optional;

public class Products {
	private final List<Product> products;

	public Products(List<Product> products) {
		this.products = products;
	}

	public boolean isBuy(int enteredAmount) {
		return products.stream()
			.filter(e -> !e.isEmpty())
			.mapToInt(Product::getAmount)
			.min()
			.orElse(0) <= enteredAmount;
	}

	public boolean isEmpty() {
		return products.stream()
			.filter(Product::isEmpty)
			.count() == products.size();
	}

	public Optional<Product> findByName(String name) {
		return products.stream()
			.filter(e -> e.getName().equals(name))
			.findFirst();
	}

}
