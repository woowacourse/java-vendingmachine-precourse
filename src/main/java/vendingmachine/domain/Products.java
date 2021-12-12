package vendingmachine.domain;

import java.util.ArrayList;

public class Products {
	private final ArrayList<Product> products = new ArrayList<>();

	public Products() {

	}

	public void add(Product product) {
		products.add(product);
	}
}
