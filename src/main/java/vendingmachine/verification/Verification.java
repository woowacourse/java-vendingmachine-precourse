package vendingmachine.verification;

public class Verification {

	private static final String NOT_INTEGER_ERROR = "[ERROR] 금액은 숫자여야 합니다.\n";
	private static final String NOT_MULTIPLE_OF_TEN_ERROR = "[ERROR] 금액은 10원 단위여야 합니다.\n";

	private static final String INTEGER = "-?\\d+";
	private static final int TEN = 10;
	private static final int ZERO = 0;

	public static int ofMoney(String input) throws IllegalArgumentException{
		if (!input.matches(INTEGER)) {
			throw new IllegalArgumentException(NOT_INTEGER_ERROR);
		}

		int money = Integer.parseInt(input);

		if (money <= ZERO || money % TEN != ZERO) {
			throw new IllegalArgumentException(NOT_MULTIPLE_OF_TEN_ERROR);
		}

		return money;
	}
}
