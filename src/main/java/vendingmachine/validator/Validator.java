package vendingmachine.validator;

import vendingmachine.exception.BlankStringException;
import vendingmachine.exception.NotAMultipleException;
import vendingmachine.exception.NotGreaterThanOrEqualsException;
import vendingmachine.exception.NotNaturalNumberException;
import vendingmachine.exception.NotNumericException;
import vendingmachine.utils.NumberUtils;
import vendingmachine.utils.StringUtils;

public class Validator {
	private static final String SPACE_CHAR = " ";
	private static final String BLANK_CHAR = "";

	protected static void validateNumeric(String input) {
		if (!StringUtils.isNumeric(input)) {
			throw new NotNumericException();
		}
	}

	protected static void validateNotBlank(String input) {
		String replacedInput = input.replace(SPACE_CHAR, BLANK_CHAR);
		if (replacedInput.equals(BLANK_CHAR)) {
			throw new BlankStringException();
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

	protected static void validateGreaterThanOrEqual(int input, int threshold) {
		if (input < threshold) {
			throw new NotGreaterThanOrEqualsException(threshold);
		}
	}
}
