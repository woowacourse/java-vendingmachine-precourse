package vendingmachine.model;

import vendingmachine.util.NumberChecker;

public class TheNumber {

	private int theNumber;

	public TheNumber(String input) {
		checkInput(input);
		theNumber = Integer.valueOf(input);
	}

	private void checkInput(String input) {
		NumberChecker numberChecker = new NumberChecker();
		numberChecker.isPositiveInteger(input);
	}

	public int get() {
		return theNumber;
	}

	public void minus() {
		theNumber--;
	}

	public boolean isZero() {

		if (theNumber == 0) {
			return true;
		}

		return false;
	}
}
