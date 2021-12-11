package vendingmachine.view;

import java.util.ArrayList;
import java.util.List;

import vendingmachine.domain.Product;

public class Converter {
	private static String PRODUCT_DELIMITER = ";";

	private final Validator validator;

	public Converter() {
		this.validator = new Validator();
	}

	public int convertMoney(String inputString) {
		return validator.validateMoney(inputString);
	}

	public List<Product> convertToProductList(String inputString) {
		String [] splits = validator.splitWithDelimiter(inputString, PRODUCT_DELIMITER);
		List<Product> products = new ArrayList<>();
		for(String productString : splits) {
			Product product = validator.validateProduct(productString);
			validator.validateProductExist(products, product.getName());
			products.add(product);
		}
		return products;
	}


}
