package vendingmachine.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Products {
	private List<Product> products;

	public Products(List<Product> products) {
		isValidateDuplicated(products);
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

	private void isValidateDuplicated(List<Product> products) {
		final Set<String> distinctProductsName = products.stream()
			.map(product -> product.getName())
			.map(name -> name.getName())
			.collect(Collectors.toSet());

		if (distinctProductsName.size() != products.size()) {
			throw new IllegalArgumentException();
		}
	}
}
