package vendingmachine.validation.validator;

import vendingmachine.validation.GlobalValidation;

public class InputProductsValidator {

	public static void validateProducts(String inputStr) {
		GlobalValidation.validateInputIsNull(inputStr);
		GlobalValidation.validateProductsInputFormat(inputStr);
	}
}
