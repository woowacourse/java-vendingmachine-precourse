package vendingmachine.util.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import vendingmachine.model.Product;
import vendingmachine.util.ErrorMessageConstants;

public class ProductValidator {

	public static void validate(List<Product> products) {
		validateProductsPrice(products);
		validateDuplication(products);
	}

	private static void validateDuplication(List<Product> products) {
		Set<String> uniqueProductNames = products.stream().map(Product::getName).collect(Collectors.toSet());
		if (uniqueProductNames.size() != products.size()) {
			throw new IllegalArgumentException(ErrorMessageConstants.DUPLICATED_PRODUCTS_EXCEPTION_MESSAGE);
		}
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
