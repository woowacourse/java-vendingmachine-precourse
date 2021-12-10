package vendingmachine.validator;

public class MoneyValidator {

	private static final int PRICE_MINIMUM_LIMIT = 100;

	public static boolean isValidMoney(String input) {
		checkNumber(input);
		checkMultipleOfTen(input);

		return true;
	}

	public static void checkProductPrice(String productPrice) {
		checkNumber(productPrice);
		checkMultipleOfTen(productPrice);
		checkMinimumLimit(productPrice);
	}

	public static void checkNumber(String input) {
		for (int i = 0; i < input.length(); i++) {
			if (!Character.isDigit(input.charAt(i))) {
				throw new IllegalArgumentException("금액은 자연수여야 합니다.");
			}
		}
	}

	public static void checkMultipleOfTen(String input) {
		if (input.charAt(input.length() - 1) != '0') {
			throw new IllegalArgumentException("금액은 10으로 나누어떨어져야 합니다.");
		}
	}

	public static void checkMinimumLimit(String productPrice) {
		if (Integer.parseInt(productPrice) < PRICE_MINIMUM_LIMIT) {
			throw new IllegalArgumentException("상품 가격은 " + PRICE_MINIMUM_LIMIT + "원 이상 이어야합니다.");
		}
	}

}
