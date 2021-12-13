package vendingmachine.validation.validator;

import vendingmachine.validation.GlobalValidation;

public class InputProductsValidator {

	public static void validateProducts(String inputStr) {
		GlobalValidation.validateNull(inputStr);
		GlobalValidation.validateProductsInputFormat(inputStr);
	}
}
