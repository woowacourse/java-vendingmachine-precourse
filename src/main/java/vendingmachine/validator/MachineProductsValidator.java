package vendingmachine.validator;

import static vendingmachine.Constants.*;

import java.util.List;

import vendingmachine.service.ProductService;
import vendingmachine.view.ErrorView;

public class MachineProductsValidator extends CommonValidator{
	public static boolean checkMachineProducts(String inputLine) {
		try {
			exceptionStringEmpty(inputLine);
			exceptionInvalidProduct(inputLine);
			return true;
		} catch (IllegalArgumentException exception) {
			ErrorView.error(ERROR_PRODUCTS);
			return false;
		}
	}

	private static void exceptionInvalidProduct(String inputLine) {
		List<String> productLines = ProductService.splitProductsInformation(inputLine);
		if (!isAllProductsValid(productLines) || isDuplicatedProduct(productLines)) {
			throw new IllegalArgumentException();
		}
	}

	private static boolean isDuplicatedProduct(List<String> productLines) {
		long count = productLines.stream()
			.map(line -> ProductService.splitProductElements(line).get(0))
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
