package vendingmachine;

import java.util.ArrayList;
import java.util.List;

public class ProductFactory {
	public List<Product> createProducts(String request) {
		List<Product> products = new ArrayList<>();
		for (String each : request.split(";")) {
			products.add(new Product(each));
		}
		return products;
	}
}
