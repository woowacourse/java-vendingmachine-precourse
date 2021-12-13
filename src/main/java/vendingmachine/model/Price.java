package vendingmachine.model;

import vendingmachine.constant.Rule;
import vendingmachine.util.NumberChecker;

public class Price implements Comparable<Price> {

	private int price;

	public Price(String input) {
		checkInput(input);
		price = Integer.valueOf(input);
	}

	public int get() {
		return price;
	}

	private void checkInput(String input) {
		NumberChecker numberChecker = new NumberChecker();
		numberChecker.isPositiveInteger(input);
		numberChecker.isLessThan(input, Rule.MIN_PRICE);
		numberChecker.isDivisibleNumber(input, Coin.minAmount());
	}

	@Override
	public int compareTo(Price o) {
		return price - o.price;
	}
}
