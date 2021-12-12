package vendingmachine.repository;

import java.util.ArrayList;
import java.util.List;

import vendingmachine.domain.Product;

public class ProductRepository {
	private static final List<Product> products = new ArrayList<>();

	public void add(List<String> info) {
		products.add(new Product(info.get(0), Integer.parseInt(info.get(1)), Integer.parseInt(info.get(2))));
	}

	public void deleteAll() {
		products.clear();
	}
}
