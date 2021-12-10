package vendingmachine.util;

import static vendingmachine.constant.Constant.*;

public class Validator {

	public void validateNumber(String number) {
		boolean isNumeric = number.matches(REGEX_EXPRESSION_OF_NUMBER);
		if (!isNumeric) {
			throw new IllegalArgumentException(VALIDATE_NUMBER_MESSAGE);
		}
	}
}
