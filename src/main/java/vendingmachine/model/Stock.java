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

	private Map<Name, Product> stock;

	public Stock(String input) {
		checkInput(input);
		stock = setStockWithoutDuplication(input);
	}

	private void checkInput(String input) {
		StringChecker stringChecker = new StringChecker();
		stringChecker.isEmpty(input);
		stringChecker.containSpace(input);
		stringChecker.containTap(input);

		SplitChecker splitChecker = new SplitChecker();
		splitChecker.exceedMaxSplit(input, Rule.DELIMITER_PRODUCT);
		splitChecker.hasZeroLength(input, Rule.DELIMITER_PRODUCT);
	}

	private Map<Name, Product> setStockWithoutDuplication(String input) {
		Map<Name, Product> productMap = new HashMap<>();
		List<String> productInfoList = Arrays.asList(input.split(Rule.DELIMITER_PRODUCT));

		for (String productInfo : productInfoList) {
			Product product = new Product(productInfo);

			if (productMap.containsKey(product.getName())) {
				throw new IllegalArgumentException(Message.ERROR_PRODUCT_DUPLICATION);
			}

			productMap.put(product.getName(), product);
		}

		return productMap;
	}

	public Product getProduct(Name name) {

		if (hasProduct(name)) {
			Product selectedProduct = stock.get(name);
			return selectedProduct;
		}

		return null;
	}

	private boolean hasProduct(Name name) {

		if (stock.get(name) == null) {
			throw new IllegalArgumentException(Message.ERROR_NON_EXISTENT_PRODUCT);
		}

		return true;
	}

	public Product giveProduct(Name name) {
		Product selectedProduct = getProduct(name);
		subtractProduct(selectedProduct);
		return selectedProduct;
	}

	private void subtractProduct(Product product) {
		product.minusTheNumber();

		if (product.theNumberIsZero()) {
			stock.remove(product.getName());
			return;
		}

		stock.put(product.getName(), product);
	}

	public boolean isEmpty() {
		return stock.isEmpty();
	}

	public Price getMinPrice() {
		return Collections.min(getPriceList());
	}

	private List<Price> getPriceList() {
		List<Price> priceList = new ArrayList<>();

		for (Map.Entry<Name, Product> productEntry : stock.entrySet()) {
			priceList.add(productEntry.getValue().getPrice());
		}

		return priceList;
	}
}
