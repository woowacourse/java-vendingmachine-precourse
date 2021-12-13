package vendingmachine.validation.validator;

import vendingmachine.validation.GlobalValidation;

public class InputVendingMachineCostValidator {

	public static void validateVendingMachineCost(String inputStr) {
		GlobalValidation.validateInputIsNull(inputStr);
		GlobalValidation.validateCostIsNaturalNumber(inputStr);
		GlobalValidation.validateCostIsDivideTen(inputStr);

	}
}
