package vendingmachine.Utils.Validator;

import java.util.Arrays;

import vendingmachine.Utils.Constants;

public class BeverageValidator {
	private final String beverageString;

	public BeverageValidator(String beverage) {
		beverageString = beverage;
		validate();
	}

	private void validate() {
		isRightString();
		isNoDuplicate();
	}

	private void isRightString() {
		if (!Constants.BEVERAGES_PATTERN.matcher(beverageString).matches()) {
			throw new IllegalArgumentException(Constants.ERROR_BEVERAGE_STRING);
		}
	}

	private void isNoDuplicate() {
		String[] beverageNames = Arrays
			.stream(beverageString.split(Constants.SEPARATOR))
			.map(beverage -> beverage.split(Constants.DELIMITER)[0])
			.toArray(String[]::new);

		if (beverageNames.length != Arrays.stream(beverageNames).distinct().count()) {
			throw new IllegalArgumentException(Constants.ERROR_BEVERAGE_DUPLICATED);
		}
	}
}
