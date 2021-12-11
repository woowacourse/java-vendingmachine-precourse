package vendingmachine.controller;

public class InputValidator {
	public static int isNumber(String input) {
		for (int i = 0; i < input.length(); i++) {
			if (!Character.isDigit(input.charAt(i))) {
				throw new IllegalArgumentException();
			}
		}
		return Integer.parseInt(input);
	}
}
