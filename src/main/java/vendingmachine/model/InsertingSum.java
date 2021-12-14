package vendingmachine.model;

import vendingmachine.util.NumberChecker;
import vendingmachine.util.StringChecker;

public class InsertingSum {

	private int insertingSum;

	public InsertingSum(String input) {
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

	public int get() {
		return insertingSum;
	}

	public void subtract(int amount) {

		if (amount > 0 && insertingSum >= amount) {
			insertingSum -= amount;
		}

	}

	public void subtract(Price price) {

		if (!isLessThan(price)) {
			insertingSum -= price.get();
		}

	}

	public boolean isLessThan(Price price) {

		if (insertingSum < price.get()) {
			return true;
		}

		return false;
	}
}
