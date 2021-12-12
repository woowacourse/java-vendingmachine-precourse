package vendingmachine.Utils.Validator;

import vendingmachine.Utils.Constants;

public class NumberValidator {
	private final String numberString;

	public NumberValidator(String numberString) {
		this.numberString = numberString;
		isRightString();
	}

	private void isRightString() {
		if (!Constants.NUMBER_PATTERN.matcher(numberString).matches()) {
			throw new IllegalArgumentException(Constants.ERROR_NUMBER_PATTERN);
		}
	}
}
