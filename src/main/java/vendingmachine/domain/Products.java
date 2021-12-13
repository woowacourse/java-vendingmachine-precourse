package vendingmachine.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Products {
	private List<Product> products = new ArrayList<>();

	public Products() {}

	public void add(Product product) {
		products.add(product);
	}

	public Money getCheapestPrice() {
		Collections.sort(products);
		for (Product product : products) {
			if (!product.soldOut()) {
				return product.getPrice();
			}
		}
		return new Money(0);
	}

	public boolean soldOut() {
		for (Product product : products) {
			if (!product.soldOut()) {
				return false;
			}
		}
		return true;
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
