package vendingmachine.reader.validator.number;

import vendingmachine.reader.validator.Validator;

public class NumberFormatValidator implements Validator {
	@Override
	public boolean validate(String value) {
		return value.matches("[0-9]*");
	}

	@Override
	public String getErrorMessage(String value, String inputValueName) {
		return "[ERROR] " + inputValueName + "는 숫자 여야 합니다.";
	}
}
