package vendingmachine.validator;

public class MoneyValidator {

	public static boolean isValidMoney(String input) {
		checkNumber(input);

		checkMultipleOfTen(input);

		return true;
	}

	private static void checkNumber(String input) {
		for (int i = 0; i < input.length(); i++) {
			if (!Character.isDigit(input.charAt(i))) {
				throw new IllegalArgumentException("금액은 자연수여야 합니다.");
			}
		}
	}

	private static void checkMultipleOfTen(String input) {
		if (input.charAt(input.length() - 1) != '0') {
			throw new IllegalArgumentException("금액은 10으로 나누어떨어져야 합니다.");
		}
	}

}
