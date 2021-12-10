package vendingmachine.domain.product;

import java.util.HashMap;
import java.util.Map;

public enum ProductFactory {
	PRODUCT_FACTORY;

	private final Map<String, Product> PRODUCT_INSTANCE = new HashMap<>();

	public Product createProduct(String name, int price, int amount) {
		Product product = PRODUCT_INSTANCE.get(name);
		if (product == null) {
			product = new Product(name, price, amount);
			PRODUCT_INSTANCE.put(name, product);
		}
		return product;
	}

}
