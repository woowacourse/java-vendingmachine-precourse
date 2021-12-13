package vendingmachine.domain;

import java.util.LinkedHashSet;
import java.util.Set;

public class ProductSet {

	public static final String NAME = "상품목록";
	private Set<Product> products;

	public ProductSet() {
		this.products = new LinkedHashSet<>();
	}

	public ProductSet(Set<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return products.toString();
	}
}
