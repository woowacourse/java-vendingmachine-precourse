package vendingmachine.Utils.Validator;

import java.util.Arrays;

import vendingmachine.Utils.Constants;

public class ProductValidator {
	private final String PRODUCT_STRING;

	public ProductValidator(String product) {
		PRODUCT_STRING = product;
		validate();
	}

	private void validate() {
		isRightString();
		isNoDuplicate();
	}

	private void isRightString() {
		if (!Constants.PRODUCTS_PATTERN.matcher(PRODUCT_STRING).matches()) {
			throw new IllegalArgumentException(Constants.ERROR_PRODUCT_STRING);
		}
	}

	private void isNoDuplicate() {
		String[] productNames = Arrays
			.stream(PRODUCT_STRING.split(Constants.SEPARATOR))
			.map(product -> product.split(Constants.DELIMITER)[0])
			.toArray(String[]::new);

		if (productNames.length != Arrays.stream(productNames).distinct().count()) {
			throw new IllegalArgumentException(Constants.ERROR_PRODUCT_DUPLICATED);
		}
	}
}
