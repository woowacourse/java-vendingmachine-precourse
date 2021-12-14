package vendingmachine;

public abstract class NumberValidator extends Validator {
	public void isNumber(String numberInString, Error error) throws IllegalArgumentException {
		try {
			Integer.parseInt(numberInString);
		} catch (NumberFormatException exception) {
			throw new IllegalArgumentException(error.getMessage());
		}
	}

	public void isMultipleOfTen(int number, Error error) throws IllegalArgumentException {
		if (number % Constants.TEN > 0) {
			throw new IllegalArgumentException(error.getMessage());
		}
	}
}
