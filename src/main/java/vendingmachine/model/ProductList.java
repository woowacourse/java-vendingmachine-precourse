package vendingmachine.model;

import static vendingmachine.validator.ProductValidator.*;

import java.util.HashMap;

// TODO: 2021/12/08 더 좋은 이름
public class ProductList {

	private final HashMap<String, Product> hashMap;

	public ProductList() {
		this.hashMap = new HashMap<>();
	}

	public void init(String rawInput) {
		String[] productRawInputList = rawInput.split(PRODUCT_CRITERIA, -1);
		for (String productRawInput : productRawInputList) {
			String[] arguments = createProductArguments(productRawInput);

			String name = arguments[0];
			int price = Integer.parseInt(arguments[1]);
			int quantity = Integer.parseInt(arguments[2]);

			Product product = new Product(name, price, quantity);
			hashMap.put(name, product);
		}
	}

	private String[] createProductArguments(String productRawInput) {
		String bracketRemovedInput = productRawInput.replace(OPENING_BRACKET, "")
			.replace(CLOSING_BRACKET, "");

		return bracketRemovedInput.split(ARGUMENT_CRITERIA, -1);
	}

	public boolean isExistProduct(String productName) {
		return hashMap.containsKey(productName);
	}

	public boolean isQuantitySufficient(String productName) {
		Product product = findProduct(productName);
		return product.getQuantity() > 0;
	}

	public boolean isTooExpensive(String productName, int currentDeposit) {
		Product product = findProduct(productName);
		return product.getPrice() > currentDeposit;
	}

	public void subtractQuantity(String productName) {
		Product product = findProduct(productName);
		product.subtractQuantity();
		hashMap.replace(productName, product);
	}

	public int getPrice(String productName) {
		Product product = findProduct(productName);
		return product.getPrice();
	}

	private Product findProduct(String productName) {
		return hashMap.get(productName);
	}

	private int getMinimumPrice() {
		int minimumPrice = Integer.MAX_VALUE;
		for (Product product : hashMap.values()) {
			if (product.getQuantity() == 0) {
				continue;
			}

			minimumPrice = Math.min(minimumPrice, product.getPrice());
		}

		return minimumPrice;
	}

}
