package vendingmachine.utils;

public class DataParser {
	public static int parseInt(String string, String errorMessage) {
		try {
			return Integer.parseInt(string.trim());
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(errorMessage);
		}
	}
}
