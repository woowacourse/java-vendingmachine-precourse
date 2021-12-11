package vendingmachine.model.service;

import java.util.ArrayList;

import vendingmachine.model.Product;
import vendingmachine.model.repository.ProductRepository;

public class ProductService {

	public static final int INDEX_OF_NAME = 0;
	public static final int INDEX_OF_PRICE = 1;
	public static final int INDEX_OF_STOCK = 2;

	private ProductRepository productRepository = ProductRepository.instance;

	public void addProducts(ArrayList<String[]> splitInfoArrList) {
		for (String[] splitInfoArr : splitInfoArrList) {
			Product product = new Product(splitInfoArr[INDEX_OF_NAME],
				Integer.parseInt(splitInfoArr[INDEX_OF_PRICE]),
				Integer.parseInt(splitInfoArr[INDEX_OF_STOCK]));

			productRepository.getProductRepository().add(product);
		}
	}
}
