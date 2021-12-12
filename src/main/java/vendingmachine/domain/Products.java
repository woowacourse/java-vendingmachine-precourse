package vendingmachine.domain;

import java.util.ArrayList;
import java.util.List;

public class Products {
	private static final String PRODUCTS_DELIMITER = ",";
	private static final String PRODUCTS_DELIMITER_PREFIX = "[";
	private static final String PRODUCTS_DELIMITER_SUFFIX = "]";
	private static final int ZERO = 0;
	private static final int ONE = 1;
	private static final int TWO = 2;

	private final List<Product> products;

	Products(final List<Product> products) {
		this.products = new ArrayList<>(products);
	}

	public static Products save(String[] products) {
		List<Product> newProduct = new ArrayList<>();
		for (String productInfo : products) {
			if (productInfo.substring(ZERO, ONE).equals(PRODUCTS_DELIMITER_PREFIX)) {
				productInfo = productInfo.substring(ONE);
			}
			if (productInfo.substring(productInfo.length() - ONE).equals(PRODUCTS_DELIMITER_SUFFIX)) {
				productInfo = productInfo.substring(ZERO, productInfo.length() - ONE);
			}
			String[] productNameAndPriceAndCnt = productInfo.split(PRODUCTS_DELIMITER);
			newProduct.add(new Product(productNameAndPriceAndCnt[ZERO],
				Integer.parseInt(productNameAndPriceAndCnt[ONE]),
				Integer.parseInt(productNameAndPriceAndCnt[TWO])));
		}
		return new Products(newProduct);
	}

	public static Products buy(String buyProductName, Products products) {
		List<Product> newProducts = new ArrayList<>();
		List<Product> productList = products.getProducts();
		for (Product product : productList) {
			if (product.getName().equals(buyProductName)) {
				product = product.reduce(ONE);
			}
			newProducts.add(product);
		}
		return new Products(newProducts);
	}

	public List<Product> getProducts() {
		return this.products;
	}

	public int getProductPrice(String buyProductName, Products products) {
		List<Product> productList = products.getProducts();
		for (Product product : productList) {
			if (product.getName().equals(buyProductName)) {
				return product.getPrice();
			}
		}
		return ZERO;
	}
}