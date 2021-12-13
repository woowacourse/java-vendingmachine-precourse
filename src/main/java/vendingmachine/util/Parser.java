package vendingmachine.util;

public class Parser {
	public static int convertStringToInt(String input) throws IllegalArgumentException {
		Validator.isEmpty(input);
		Validator.isNumber(input);
		return Integer.parseInt(input);
	}
}
