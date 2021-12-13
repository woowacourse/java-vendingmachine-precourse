package vendingmachine.validator;

import java.util.List;

import vendingmachine.service.ProductService;

public class MachineProductsValidator extends CommonValidator{
	public static boolean checkMachineProducts(String inputLine) {
		try {
			exceptionStringEmpty(inputLine);
			exceptionInvalidProduct(inputLine);
			return true;
		} catch (IllegalArgumentException exception) {
			return false;
		}
	}

	private static void exceptionInvalidProduct(String inputLine) {
		List<String> productLines = ProductService.splitBySemicolon(inputLine);
		if (!isAllProductsValid(productLines) || isDuplicatedProduct(productLines)) {
			throw new IllegalArgumentException();
		}
	}

	private static boolean isDuplicatedProduct(List<String> productLines) {
		long count = productLines.stream()
			.map(line -> ProductService.splitByComma(line).get(0))
			.distinct().count();
		if (count != productLines.size()) {
			return true;
		}
		return false;
	}

	private static boolean isAllProductsValid(List<String> productLines) {
		return productLines.stream()
			.allMatch(productLine -> ProductValidator.checkProduct(productLine));
	}
}
