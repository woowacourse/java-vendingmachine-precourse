package vendingmachine.util.parser;

import vendingmachine.util.validator.CoinValidator;

public class Parser {
	public static int convertStringToInt(String input) throws IllegalArgumentException {
		CoinValidator.isRightCoin(input);
		return Integer.parseInt(input);
	}
}
