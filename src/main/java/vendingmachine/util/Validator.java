package vendingmachine.util;

import vendingmachine.message.Error;
import vendingmachine.model.Product;

public class Validator {
	public static final void onlyNums(String input) {
		for (char c : input.toCharArray()) {
			if(!Character.isDigit(c)) {
				throw new IllegalArgumentException(Error.NOT_ONLY_NUMS);
			}
		}
	}

	public static final boolean isOnlyNums(String input) {
		for (char c : input.toCharArray()) {
			if(!Character.isDigit(c)) {
				return false;
			}
		}
		return true;
	}

	public static final void rightPrice(String input) {
		int price = Integer.parseInt(input);
		if (price < Product.MINIMUM_PRICE) {
			throw new IllegalArgumentException(Error.LESS_THEN_MINIMUM_PRICE);
		}
		if (price % Product.MINIMUM_PRICE_UNIT != 0) {
			throw new IllegalArgumentException(Error.WRONG_PRICE_UNIT);
		}
	}
}
