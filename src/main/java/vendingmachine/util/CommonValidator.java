package vendingmachine.util;

import vendingmachine.model.Product;

public class CommonValidator {
	public static final boolean isOnlyNums(String input) {
		for (char c : input.toCharArray()) {
			if(!Character.isDigit(c)) {
				return false;
			}
		}
		return true;
	}

	public static final boolean rightMinimumUnit(String input) {
		int price = Integer.parseInt(input);
		if (price % Product.MINIMUM_PRICE_UNIT != 0) {
			return false;
		}
		return true;
	}
}
