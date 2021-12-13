package vendingmachine.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Products {
	private final List<Product> products;

	public Products(String inputProducts) {
		this.products = createProducts(inputProducts);
	}

	private List<Product> createProducts(String inputProducts) {
		System.out.println(inputProducts);
		String[] split = inputProducts.split(";");

		return Arrays.stream(split)
			.map(str -> new Product(getProductSplit(str)))
			.collect(Collectors.toList());
	}

	private String[] getProductSplit(String str) {
		return str.substring(1, str.length() - 1).split(",");
	}
}
