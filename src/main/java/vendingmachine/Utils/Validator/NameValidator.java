package vendingmachine.Utils.Validator;

import vendingmachine.Utils.Constants;

public class NameValidator {
	private final String name;

	public NameValidator(String name) {
		this.name = name;
		isRightString();
	}

	private void isRightString() {
		if (!Constants.NAME_PATTERN.matcher(name).matches()) {
			throw new IllegalArgumentException(Constants.ERROR_NAME_STRING);
		}
	}
}
