package vendingmachine.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import vendingmachine.constant.Message;
import vendingmachine.constant.Rule;
import vendingmachine.util.SplitChecker;
import vendingmachine.util.StringChecker;

public class Stock {

	private List<Product> productList;
	private Map<Product, Integer> productIndex;

	public Stock(String input) {
		checkInput(input);
		List<Product> productList = new ArrayList<>();
		List<String> productInfoList = Arrays.asList(input.split(Rule.DELIMETER_PRODUCT));

		for (String productInfo : productInfoList) {
			Product product = new Product(productInfo);
			productList.add(product);
		}

		checkDuplication(productList);
		setProductIndex(productList);
		this.productList = productList;
	}

	private void checkInput(String input) {
		StringChecker stringChecker = new StringChecker();
		stringChecker.isEmpty(input);
		stringChecker.containSpace(input);
		stringChecker.containTap(input);

		SplitChecker splitChecker = new SplitChecker();
		splitChecker.exceedMaxSplit(input, Rule.DELIMETER_PRODUCT);
		splitChecker.hasZeroLength(input, Rule.DELIMETER_PRODUCT);
	}

	private void checkDuplication(List<Product> productList) {
		Set<Product> productSet = new HashSet<>();

		for (Product product : productList) {

			if (productSet.contains(product)) {
				throw new IllegalArgumentException(Message.ERROR_MESSAGE_PRODUCT_DUPLECATION);
			}

			productSet.add(product);
		}

	}

	private void setProductIndex(List<Product> productList) {

	}
}
