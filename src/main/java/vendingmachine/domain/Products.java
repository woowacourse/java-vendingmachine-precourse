package vendingmachine.domain;

import java.util.ArrayList;
import java.util.List;

public class Products {
	private final ArrayList<Product> products = new ArrayList<>();

	public Products(List<List<String>> productsInfoList) {
		for (List<String> productInfo : productsInfoList) {
			products.add(new Product(productInfo));
		}
	}

	public void add(Product product) {
		products.add(product);
	}
}
