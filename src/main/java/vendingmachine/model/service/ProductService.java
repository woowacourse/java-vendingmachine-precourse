package vendingmachine.model.service;

import java.util.ArrayList;

import vendingmachine.model.Product;
import vendingmachine.model.repository.ProductRepository;

public class ProductService {

	public static final int INDEX_OF_NAME = 0;
	public static final int INDEX_OF_PRICE = 1;
	public static final int INDEX_OF_STOCK = 2;
	public static final String FAIL_TO_FIND_MESSAGE_THROUGH_PRODUCT_NAME = "FailToFind";
	public static final int OUT_OF_STOCK_COUNT = 0;

	ProductRepository productRepository = ProductRepository.instance;

	public void addProducts(ArrayList<String[]> splitInfoArrList) {
		for (String[] splitInfoArr : splitInfoArrList) {
			Product product = new Product(splitInfoArr[INDEX_OF_NAME],
				Integer.parseInt(splitInfoArr[INDEX_OF_PRICE]),
				Integer.parseInt(splitInfoArr[INDEX_OF_STOCK]));

			productRepository.getProductRepository().add(product);
		}
	}

	public Product getByName(String name) {
		for (Product product : productRepository.getProductRepository()) {
			if (product.getName().equals(name)) {
				return product;
			}
		}

		return new Product(FAIL_TO_FIND_MESSAGE_THROUGH_PRODUCT_NAME, 100, 1);
	}

	public int getMinPrice() {
		int minPrice = Integer.MAX_VALUE;
		for (Product product : productRepository.getProductRepository()) {
			minPrice = Math.min(minPrice, product.getPrice());
		}

		return minPrice;
	}

	public boolean checkAllStocksEmpty() {
		for (Product product : productRepository.getProductRepository()) {
			if (product.getStock() != OUT_OF_STOCK_COUNT) {
				return false;
			}
		}

		return true;
	}
}
