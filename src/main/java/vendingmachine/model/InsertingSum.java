package vendingmachine.model;

import vendingmachine.util.NumberChecker;
import vendingmachine.util.StringChecker;

public class InsertingSum {

	private int insertingSum;

	public InsertingSum(String input) {
		checkInput(input);
		insertingSum = Integer.valueOf(input);
	}

	public int get() {
		return insertingSum;
	}

	private void checkInput(String input) {
		StringChecker stringChecker = new StringChecker();
		stringChecker.isEmpty(input);

		NumberChecker numberChecker = new NumberChecker();
		numberChecker.isPositiveInteger(input);
		numberChecker.isDivisibleNumber(input, Coin.minAmount());
	}

	public void subtract(int amount) {
		insertingSum -= amount;
	}

	public boolean isLessThan(Price price) {

		if (insertingSum < price.get()) {
			return true;
		}

		return false;
	}

	public void initialization() {
		insertingSum = 0;
	}
}
