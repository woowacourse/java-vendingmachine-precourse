package vendingmachine.reader.validator.number;

import vendingmachine.reader.validator.Validator;

public class OverBoundaryValidator implements Validator {
	private final int boundaryValue;

	public OverBoundaryValidator(int boundaryValue) {
		this.boundaryValue = boundaryValue;
	}

	@Override
	public boolean validate(String value) {
		return Integer.valueOf(value) >= boundaryValue;
	}

	@Override
	public String getErrorMessage(String value, String inputValueName) {
		return "[ERROR] " + inputValueName + "은 " + boundaryValue + "를 넘어야 합니다.";
	}
}
