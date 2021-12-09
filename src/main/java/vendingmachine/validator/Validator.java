package vendingmachine.validator;

import vendingmachine.exception.NotAMultipleException;
import vendingmachine.exception.NotNaturalNumberException;
import vendingmachine.exception.NotNumericException;
import vendingmachine.utils.NumberUtils;
import vendingmachine.utils.StringUtils;

public class Validator {
	protected static void validateNumeric(String input) {
		if (!StringUtils.isNumeric(input)) {
			throw new NotNumericException();
		}
	}

	protected static void validateNaturalNumber(int input) {
		if (!NumberUtils.isNaturalNumber(input)) {
			throw new NotNaturalNumberException();
		}
	}

	protected static void validateMultiple(int input, int multiple) {
		if (NumberUtils.isMultipleOf(input, multiple)) {
			throw new NotAMultipleException(multiple);
		}
	}
}
