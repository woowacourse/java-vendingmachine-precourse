package vendingmachine.validation.validator;

import vendingmachine.validation.GlobalValidation;

public class InputVendingMachineCostValidator {

	public static void validateVendingMachineCost(String inputStr) {
		GlobalValidation.validateNull(inputStr);
		GlobalValidation.validateCostIsNaturalNumber(inputStr);
		GlobalValidation.validateDivideTen(Integer.parseInt(inputStr));

	}
}
