package vendingmachine.domain;

import java.util.ArrayList;
import java.util.HashMap;

public class ProductRepository {
	private final static int LAST_NUMBER = 1;
	private final static String INVALID_PRODUCT_MESSAGE = "해당 상품이 존재히자 않습니다.";

	private final ArrayList<Product> products = new ArrayList<>();
	private final HashMap<Product, Integer> productHashMap = new HashMap<>();

	public void addProduct(Product product, int number) {
		products.add(product);
		productHashMap.put(product, number);
	}

	public int getProductCost(String productName) {
		return findProduct(productName).getCost();
	}

	public boolean isOutOfStock() {
		return productHashMap.isEmpty();
	}

	public boolean isNoProductForCustomer(int customerMoney) {
		for (Product product : products) {
			if (product.isChipperThanMoney(customerMoney)) {
				return false;
			}
		}
		return true;
	}

	public void sellProduct(String productName) {
		Product product = findProduct(productName);
		int beforeNumberOfProduct = productHashMap.get(product);
		if (beforeNumberOfProduct == LAST_NUMBER) {
			productHashMap.remove(product);
			return;
		}
		productHashMap.replace(product, beforeNumberOfProduct - 1);
	}

	private Product findProduct(String productName) {
		for (Product product : products) {
			if (product.isSame(productName)) {
				return product;
			}
		}
		throw new IllegalArgumentException(INVALID_PRODUCT_MESSAGE);
	}
}
