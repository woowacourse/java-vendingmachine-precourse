package vendingmachine.validator;

import java.util.stream.Stream;

public class InputValidator {
	public static boolean isEmptyString(String input) {
		return !input.trim().equals("");
	}

	public static boolean isDigit(String input) {
		return Stream.of(input.split(""))
			.map(c -> c.charAt(0))
			.allMatch(Character::isDigit);
	}

	public static boolean isGreaterThan(int standard, String input) {
		return Integer.parseInt(input) >= standard;
	}

	public static boolean isDivided(int denominator, String input) {
		return Integer.parseInt(input) % denominator == 0;
	}
}
