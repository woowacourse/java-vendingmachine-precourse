package vendingmachine;

public abstract class NumberValidator extends Validator {
	void isNumber(String numberInString, Error error) throws IllegalArgumentException {
		try {
			Integer.parseInt(numberInString);
		} catch (NumberFormatException exception) {
			throw new IllegalArgumentException(error.getMessage());
		}
	}

	void isMultipleOfTen(int number, Error error) throws IllegalArgumentException {
		if (number % Constants.TEN > Constants.ZERO) {
			throw new IllegalArgumentException(error.getMessage());
		}
	}
}
