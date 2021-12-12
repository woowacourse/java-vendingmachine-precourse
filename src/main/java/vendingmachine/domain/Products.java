package vendingmachine.domain;

import java.util.ArrayList;
import java.util.List;

public class Products {
	private final ArrayList<Product> products = new ArrayList<>();

	public Products() {
	}

	public void add(Product product) {
		products.add(product);
	}

	public boolean isContains(Product product) {
		return products.contains(product);
	}
}
