package vendingmachine.utils;

import java.util.regex.Pattern;

public class InputtedDataValidation {

	private static final String NUMBER_PATTERN = "^[0-9]*$";

	private String errorMessage;

	public InputtedDataValidation() {
		this.errorMessage = "";
	}

	public boolean validateNumberInput(final String inputtedData) {
		if(!Pattern.matches(NUMBER_PATTERN, inputtedData)) {
			errorMessage = VendingMachineMessage.notNumberError(inputtedData);
			throw new IllegalArgumentException(errorMessage);
		}
		if(inputtedData.length() <= 1) {
			errorMessage = VendingMachineMessage
				.invalidLengthError(inputtedData);
			throw new IllegalArgumentException(errorMessage);
		}
		if(inputtedData.charAt(inputtedData.length() - 1) != '0') {
			errorMessage = VendingMachineMessage
				.invalidNumberError(inputtedData);
			throw new IllegalArgumentException(errorMessage);
		}
		return true;
	}
}
