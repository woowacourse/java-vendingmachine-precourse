package vendingmachine.util;

import vendingmachine.message.Error;

public class Validator {
	public static final void onlyNums(String input) {
		for (char c : input.toCharArray()) {
			if(!Character.isDigit(c)) {
				throw new IllegalArgumentException(Error.NOT_ONLY_NUMS);
			}
		}
	}
}
