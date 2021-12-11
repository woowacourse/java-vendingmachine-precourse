package vendingmachine.view;

public class Validator {
	private static final int DIVISION_VALUE = 10;

	public void checkNumberString(String inputString) throws IllegalArgumentException{
		if(!checkSize(inputString) || !checkNumber(inputString)) {
			throw new IllegalArgumentException();
		}
	}

	private boolean checkSize(String inputString) {
		return inputString.length() > 0;
	}

	private boolean checkNumber(String inputString) {
		return inputString.chars().allMatch( Character::isDigit);
	}

	public void checkDivisionByTen(int number) throws IllegalArgumentException{
		if(number % DIVISION_VALUE != 0) {
			throw new IllegalArgumentException();
		}
	}
}
