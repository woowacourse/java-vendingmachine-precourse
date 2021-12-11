package vendingmachine.domain;

import java.util.HashMap;

public class ProductRepository {
	private final static int NUMBER_OF_NO_PRODUCT = 0;
	private final static String INVALID_PRODUCT_MESSAGE = "해당 상품이 존재하지 않습니다.";

	private final HashMap<Product, Integer> productHashMap = new HashMap<>();

	public void addProduct(Product product, int number) {
		productHashMap.put(product, number);
	}

	public int getProductCost(String productName) {
		return findProduct(productName).getCost();
	}

	public boolean canSellProduct(int customerMoney) {
		long numberOfProduct = productHashMap.keySet().stream()
			.filter(product -> product.isChipperThanMoney(customerMoney))
			.count();
		return numberOfProduct > NUMBER_OF_NO_PRODUCT;
	}

	public void sellProduct(String productName) {
		Product product = findProduct(productName);
		productHashMap.replace(product, productHashMap.get(product) - 1);
		if (productHashMap.get(product) == NUMBER_OF_NO_PRODUCT) {
			productHashMap.remove(product);
		}
	}

	private Product findProduct(String productName) {
		return productHashMap.keySet().stream()
			.filter(product -> product.isSame(productName))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException(INVALID_PRODUCT_MESSAGE));
	}
}
