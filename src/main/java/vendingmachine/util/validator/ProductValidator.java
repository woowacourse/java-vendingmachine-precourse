package vendingmachine.util.validator;

import java.util.List;

import vendingmachine.model.Product;
import vendingmachine.util.ErrorMessageConstants;

public class ProductValidator {

	public static void validate(List<Product> products) {
		validateProductsPrice(products);
	}

	private static void validateProductsPrice(List<Product> products) {
		products.forEach(product -> {
			if (!product.isPriceOverHundred()) {
				throw new IllegalArgumentException(ErrorMessageConstants.MINIMUM_PRICE_EXCEPTION_MESSAGE);
			}
			if (!product.isPriceDividedByTen()) {
				throw new IllegalArgumentException(ErrorMessageConstants.PRICE_DIVISION_EXCEPTION_MESSAGE);
			}
		});
	}
}
