package vendingmachine.domain.product;

import java.util.HashMap;
import java.util.Map;

public class ProductFactory {
	private final Map<String, Product> PRODUCT_INSTANCE = new HashMap<>();

	public Product create(String name, int price, int amount) {
		Product product = PRODUCT_INSTANCE.get(name);
		if (product == null) {
			product = new Product(name, price, amount);
			PRODUCT_INSTANCE.put(name, product);
		}
		return product;
	}

}
