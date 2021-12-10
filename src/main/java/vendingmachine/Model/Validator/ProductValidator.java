package vendingmachine.Model.Validator;

import java.util.Arrays;

import vendingmachine.Constants;

public class ProductValidator {
	public final String PRODUCT_STRING;

	public ProductValidator(String product) {
		PRODUCT_STRING = product;
		validate();
	}

	private void validate() {
		isRightString();
		isNoDuplicate();
	}

	private void isRightString() {
		if (!Constants.PRODUCT_PATTERN.matcher(PRODUCT_STRING).matches()) {
			throw new IllegalArgumentException(Constants.ERROR_PRODUCT_STRING);
		}
	}

	private void isNoDuplicate() {
		String[] productNames = Arrays
			.stream(PRODUCT_STRING.split(Constants.DELIMITER_PRODUCTS))
			.map(product -> product.split(Constants.DELIMITER_PRODUCT)[0]).toArray(String[]::new);

		if (productNames.length != Arrays.stream(productNames).distinct().count()) {
			throw new IllegalArgumentException(Constants.ERROR_PRODUCT_DUPLICATED);
		}
	}
}
