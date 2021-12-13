package vendingmachine.util.validator;

public class CoinValidator extends Validator {
	private static final int DIVISIBLE_VALUE = 10;

	public static void isRightCoin(String input) throws IllegalArgumentException {
		isEmpty(input);
		isNumber(input);
		isDivisible(input);
	}

	private static void isDivisible(String input) {
		if (Integer.parseInt(input) % DIVISIBLE_VALUE != 0) {
			throw new IllegalArgumentException("[ERROR] 10원으로 나누어 떨어져야 합니다.");
		}
	}
}
