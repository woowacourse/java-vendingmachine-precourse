package vendingmachine.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Products {
	private List<Product> products = new ArrayList<>();

	public Products() {}

	public void add(Product product) {
		products.add(product);
	}

	public Money getCheapestPrice() {
		return Collections.min(products).getPrice();
	}

	public void removeSoldOutProduct() {
		for (Product product : products) {
			if (product.soldOut()) {
				products.remove(product);
			}
		}
	}
}
