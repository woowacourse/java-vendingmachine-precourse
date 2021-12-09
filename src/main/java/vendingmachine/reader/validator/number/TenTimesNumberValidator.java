package vendingmachine.reader.validator.number;

import vendingmachine.reader.validator.Validator;

public class TenTimesNumberValidator implements Validator {
	@Override
	public boolean validate(String value) {
		return Integer.valueOf(value) % 10 == 0;
	}

	@Override
	public String getErrorMessage(String value, String inputValueName) {
		return "[ERROR] " + inputValueName + "는 10의 배수여야 합니다.";
	}
}
