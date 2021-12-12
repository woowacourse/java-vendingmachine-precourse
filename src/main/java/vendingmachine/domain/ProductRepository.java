package vendingmachine.domain;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
	private static final List<Product> products = new ArrayList<>();

	public static void add(Product product) {
		products.add(product);
	}
}
