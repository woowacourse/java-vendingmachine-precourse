package vendingmachine.validation.validator;

import java.util.List;

import vendingmachine.domain.Product;
import vendingmachine.validation.GlobalValidation;

public class InputProductNameValidator {
	public static void validateProductName(String inputStr, List<Product> products) {
		GlobalValidation.validateNull(inputStr);
		GlobalValidation.validateProductIsNotInProducts(inputStr, products);
	}
}
