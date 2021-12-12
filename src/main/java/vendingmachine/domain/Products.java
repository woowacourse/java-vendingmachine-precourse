package vendingmachine.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Products {
	private List<Product> products;

	public Products(List<Product> products) {
		this.products = products;
	}

	private Products(String[] products) {
		this(Arrays.stream(products)
			.map(Product::from)
			.collect(Collectors.toList()));
	}

	public static Products from(String[] inputProducts) {
		return new Products(inputProducts);
	}
}
