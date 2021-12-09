package vendingmachine.domain;

import java.util.ArrayList;
import java.util.HashMap;

public class ProductRepository {
	private final ArrayList<Product> products = new ArrayList<>();
	private final HashMap<Product, Integer> productHashMap = new HashMap<>();

	public void addProduct(Product product, int number) {
		products.add(product);
		productHashMap.put(product, number);
	}

	public int getProductCost(String productName) {
		for (Product product : products) {
			if (product.isSame(productName)) {
				return product.getCost();
			}
		}
		return 0;
	}

}
