package vendingmachine.Model.Validator;

import java.util.Arrays;
import java.util.Objects;

import vendingmachine.Constants;

public class NameValidator {
	public final String NAME;
	private final String[] NAMES;

	public NameValidator(String name, String[] names) {
		NAME = name;
		NAMES = names;
		validate();
	}

	private void validate() {
		isRightString();
		isInNames();
	}

	private void isRightString() {
		if (!Constants.NAME_PATTERN.matcher(NAME).matches()) {
			throw new IllegalArgumentException(Constants.ERROR_NAME_STRING);
		}
	}

	private void isInNames() {
		if (Arrays.stream(NAMES).noneMatch(name -> Objects.equals(name, NAME))) {
			throw new IllegalArgumentException(Constants.ERROR_NAME_IN_NAMES);
		}
	}
}
