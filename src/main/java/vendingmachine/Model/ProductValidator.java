package vendingmachine.Model;

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
			throw new IllegalArgumentException(Constants.ERROR);
		}
	}

	private void isNoDuplicate() {
		String[] productNames = Arrays
			.stream(PRODUCT_STRING.split(";"))
			.map(product -> product.split(",")[0]).toArray(String[]::new);

		if (productNames.length != Arrays.stream(productNames).distinct().count()) {
			throw new IllegalArgumentException(Constants.ERROR);
		}
	}
}
