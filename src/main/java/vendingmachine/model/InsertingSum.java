package vendingmachine.model;

import vendingmachine.util.NumberChecker;
import vendingmachine.util.StringChecker;

public class InsertingSum {

	private int insertingSum;

	public int get() {
		return insertingSum;
	}

	public void set(String input) {
		checkInput(input);
		insertingSum = Integer.valueOf(input);
	}

	private void checkInput(String input) {
		StringChecker stringChecker = new StringChecker();
		stringChecker.isEmpty(input);

		NumberChecker numberChecker = new NumberChecker();
		numberChecker.isPositiveInteger(input);
		numberChecker.isDivisibleNumber(input, Coin.minAmount());
	}
}
