package vendingmachine.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import vendingmachine.constant.Message;
import vendingmachine.constant.Rule;
import vendingmachine.util.SplitChecker;
import vendingmachine.util.StringChecker;

public class Stock {

	private Map<Name, Product> productMap;

	public Stock(String input) {
		checkInput(input);
		productMap = setProductMapWithoutDuplication(input);
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

	private Map<Name, Product> setProductMapWithoutDuplication(String input) {
		Map<Name, Product> productMap = new HashMap<>();
		List<String> productInfoList = Arrays.asList(input.split(Rule.DELIMETER_PRODUCT));

		for (String productInfo : productInfoList) {
			Product product = new Product(productInfo);

			if (productMap.containsKey(product.getName())) {
				throw new IllegalArgumentException(Message.ERROR_MESSAGE_PRODUCT_DUPLECATION);
			}

			productMap.put(product.getName(), product);
		}

		return productMap;
	}

	public Product giveProduct(Name name) {

		if (hasProduct(name)) {
			Product selectedProduct = productMap.get(name);
			subtractProduct(selectedProduct);
			return selectedProduct;
		}

		return null;
	}

	private boolean hasProduct(Name name) {

		if (productMap.get(name) == null) {
			throw new IllegalArgumentException("없는 상품입니다.");
		}

		return true;
	}

	private void subtractProduct(Product product) {
		product.minusTheNumber();

		if (product.theNumberisZero()) {
			productMap.remove(product.getName());
			return;
		}

		productMap.put(product.getName(), product);
	}

	public boolean isEmpty() {
		return productMap.isEmpty();
	}

	public Price getMinPrice() {
		return Collections.min(getPriceList());
	}

	private List<Price> getPriceList() {
		List<Price> priceList = new ArrayList<>();

		for (Map.Entry<Name, Product> productEntry : productMap.entrySet()) {
			priceList.add(productEntry.getValue().getPrice());
		}

		return priceList;
	}
}
