package vendingmachine.utils;

public class StringValidator {
	public static void validateNumber(String input) {
		if (!input.matches("[0-9]+")) {
			throw new IllegalArgumentException();
		}
	}

	public static void validateNumber(String input, String errorMessage) {
		if (!input.matches("[0-9]+")) {
			throw new IllegalArgumentException(errorMessage);
		}
	}
}

