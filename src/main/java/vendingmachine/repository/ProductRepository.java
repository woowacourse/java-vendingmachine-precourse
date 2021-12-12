package vendingmachine.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import vendingmachine.domain.Product;

public class ProductRepository {
	private static final List<Product> products = new ArrayList<>();

	public void add(List<String> info) {
		products.add(new Product(info.get(0), Integer.parseInt(info.get(1)), Integer.parseInt(info.get(2))));
	}

	public boolean findByName(String name) {
		return products.stream().anyMatch(product -> product.isEqual(name));
	}

	public Product getByName(String name) {
		for (Product p : products) {
			if (p.isEqual(name)) {
				return p;
			}
		}
		return null;
	}

	public int getMinimumPrice() {
		return products.stream()
			.map(Product::getPrice)
			.sorted()
			.collect(Collectors.toList())
			.get(0);
	}

	public void delete(Product product) {
		products.remove(product);
	}

	public void deleteAll() {
		products.clear();
	}

	public boolean isEmpty() {
		return products.isEmpty();
	}
}
