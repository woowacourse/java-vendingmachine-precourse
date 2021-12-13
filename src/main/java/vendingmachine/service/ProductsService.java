package vendingmachine.service;

import vendingmachine.domain.Money;
import vendingmachine.domain.Product;
import vendingmachine.domain.Products;
import vendingmachine.utils.validator.RequestValidator;

import static vendingmachine.utils.validator.RequestValidator.*;

public class ProductsService {
	private static final String PRODUCTS_REQUEST_DELIMITER = ";";
	private static final String PRODUCT_REQUEST_DELIMITER = ",";
	private static final int NAME_INDEX = 0;
	private static final int PRICE_INDEX = 1;
	private static final int COUNT_INDEX = 2;

	public static Products toProducts(String request) throws IllegalArgumentException {
		Products products = new Products();
		String[] eachProductRequest = request.split(PRODUCTS_REQUEST_DELIMITER);
		for (String productRequest : eachProductRequest) {
			RequestValidator.isMatchRegexToProduct(productRequest);
			String[] productItems = productRequest.split(PRODUCT_REQUEST_DELIMITER);
			products.add(toProduct(productItems));
		}
		return products;
	}

	public static Product toProduct(String[] productItem) throws IllegalArgumentException {
		String name = productItem[NAME_INDEX];
		isNumber(productItem[PRICE_INDEX]);
		Money price = new Money(Integer.parseInt(productItem[PRICE_INDEX]));
		isNumber(productItem[COUNT_INDEX]);
		int count = Integer.parseInt(productItem[COUNT_INDEX]);

		return new Product(name, price, count);
	}
}
