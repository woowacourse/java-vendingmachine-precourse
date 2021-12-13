package vendingmachine.validator;

public class InputUserAmountValidator {
	private final static String ONLY_NUMBER = "[0-9]+";
	private final static String ONLY_NUMBER_ERROR_MESSAGE = "[ERROR] 투입 금액은 숫자여야합니다.";
	private final static int DIVIDE_BY_10 = 10;
	private final static String DIVIDE_BY_10_ERROR_MESSAGE = "[ERROR] 투입 금액은 10으로 나누어 떨어져야합니다.";

	private InputUserAmountValidator() {
	}

	public static boolean isValidated(String inputAmount) {
		try {
			checkOnlyNumber(inputAmount);
			checkDivideBy10(inputAmount);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	private static void checkOnlyNumber(String inputAmount) {
		if (!inputAmount.matches(ONLY_NUMBER)) {
			throw new IllegalArgumentException(ONLY_NUMBER_ERROR_MESSAGE);
		}
	}

	private static void checkDivideBy10(String inputAmount) {
		if (Integer.parseInt(inputAmount) % DIVIDE_BY_10 != 0) {
			throw new IllegalArgumentException(DIVIDE_BY_10_ERROR_MESSAGE);
		}
	}
}
