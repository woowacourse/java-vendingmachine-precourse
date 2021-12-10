package vendingmachine.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import vendingmachine.constant.Rule;

public class Stock {

	private Set<Product> productSet;

	public Stock() {
		productSet = new HashSet<>();
	}

	public void set(String input) {
		checkInput(input);
		Set<Product> productSet = new HashSet<>();
		List<String> productInfoList = Arrays.asList(input.split(Rule.DELIMETER_PRODUCT));

		for (String productInfo : productInfoList) {
			Product product = new Product();
			product.set(productInfo);
			productSet.add(product);
		}

		this.productSet = productSet;
	}

	private void checkInput(String input) {

	}
}
