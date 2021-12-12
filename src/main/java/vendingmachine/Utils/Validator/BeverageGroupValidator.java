package vendingmachine.Utils.Validator;

import java.util.Arrays;

import vendingmachine.Model.Converter;
import vendingmachine.Utils.Constants;

public class BeverageGroupValidator {
	private final String beverageString;

	public BeverageGroupValidator(String beverage) {
		beverageString = beverage;
		validate();
	}

	private void validate() {
		isRightString();
		isNoDuplicate();
	}

	public void isRightString() {
		if (!Constants.BEVERAGES_PATTERN.matcher(beverageString).matches()) {
			throw new IllegalArgumentException(Constants.ERROR_BEVERAGE_STRING);
		}
	}

	private void isNoDuplicate() {
		String[] beverageNames = Converter.getBeverages(beverageString)
			.stream()
			.map(beverage -> beverage.name)
			.toArray(String[]::new);

		if (beverageNames.length != Arrays.stream(beverageNames).distinct().count()) {
			throw new IllegalArgumentException(Constants.ERROR_BEVERAGE_DUPLICATED);
		}
	}
}
