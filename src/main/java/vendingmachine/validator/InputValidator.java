package vendingmachine.validator;

import static vendingmachine.constants.ErrorMessages.*;

public class InputValidator {
	private static final InputValidator inputValidator = new InputValidator();

	private InputValidator() {
	}

	public static InputValidator getInputValidator(){
		return inputValidator;
	}

	public boolean checkInitialAmountInputExceptions(String amount){
		return checkNotMultiplicationOfTenExceptions(amount);
	}

	private boolean checkNotNaturalNumberExceptions(String string){
		try {
			if (string.chars().anyMatch(number -> !Character.isDigit(number))) {
				System.out.println(NOT_NATURAL_NUMBER_ERROR_MESSAGE);
				throw new IllegalArgumentException();
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	private boolean checkNotMultiplicationOfTenExceptions(String string){
		if (!checkNotNaturalNumberExceptions(string)) {
			return false;
		}
		int number = Integer.parseInt(string);
		try {
			if (number % 10 != 0) {
				System.out.println(NOT_NATURAL_NUMBER_ERROR_MESSAGE);
				throw new IllegalArgumentException();
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
