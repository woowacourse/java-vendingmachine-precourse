package vendingmachine.validation.validator;

import vendingmachine.validation.GlobalValidation;

public class InputCostValidator {

	public static void validateInputCost(String  inputStr) {
		GlobalValidation.validateInputIsNull(inputStr);
		GlobalValidation.validateCostIsNaturalNumber(inputStr);
		GlobalValidation.validateCostIsDivideTen(inputStr);
	}
}
