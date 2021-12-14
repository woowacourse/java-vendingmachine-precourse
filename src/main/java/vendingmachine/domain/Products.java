package vendingmachine.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Products {
	private List<Product> products = new ArrayList<>();

	public Products() {
	}

	public void add(Product product) {
		products.add(product);
	}

	public Product getCheapestProduct() {
		Collections.sort(products);
		for (Product product : products) {
			if (!product.soldOut()) {
				return product;
			}
		}
		return null;
	}

	public Product findForName(String productName) {
		for (Product product : products) {
			if (product.hashCode() == Objects.hash(productName)) {
				return product;
			}
		}
		return null;
	}
}
