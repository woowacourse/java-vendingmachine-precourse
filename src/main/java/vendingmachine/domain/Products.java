package vendingmachine.domain;

import java.util.ArrayList;
import java.util.List;

public class Products {
	private List<Product> products = new ArrayList<>();

	public Products() {}

	public void add(Product product) {
		products.add(product);
	}

}
