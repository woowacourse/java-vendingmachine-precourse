package vendingmachine.view;

import java.util.ArrayList;
import java.util.List;

import vendingmachine.constants.InputConstants;
import vendingmachine.domain.Product;

public class Converter {
	private static final int DIVISION_VALUE = 10;
	private static final int NAME_INDEX = 0;
	private static final int PRICE_INDEX = 1;
	private static final int QUANTITY_INDEX = 2;

	private final Validator validator;

	public Converter() {
		this.validator = new Validator();
	}

	public int convertToInt(String inputString) {
		return Integer.valueOf(inputString);
	}

	public List<Product> convertToProductList(String inputString) {
		String [] splits = validator.splitWithDelimiter(inputString, InputConstants.PRODUCT_DELIMITER);
		List<Product> products = new ArrayList<>();
		for(String productString : splits) {
			products.add(validator.validateProduct(productString));
		}
		return products;
	}

	public int convertStorageMoney(String inputString) {
		return validator.validateStorageMoney(inputString);
	}
}
