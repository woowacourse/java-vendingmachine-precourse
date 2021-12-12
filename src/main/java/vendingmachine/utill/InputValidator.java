package vendingmachine.utill;

public class InputValidator {
	private static final int ERROR_CODE = -1;
	private static final int DIVISOR = 10;
	private static final String ERROR_MSG = "[ERROR] ";
	private static final String INT_TYPE_ERROR_MSG = "금액은 숫자여야 합니다.";
	private static final String NEGATIVE_INT_ERROR_MSG = "금액은 0원 이상이어야 합니다.";
	private static final String NOT_DIVISIBLE_BY_10_ERROR_MSG = "금액은 10원 단위로 나누어 떨어져야 합니다.";

	public int validMachineMoney(String inputAmount) {
		try {
			int amount = inputTransferToInt(inputAmount);
			validRange(amount);
			validIsDivisibleBy10(amount);
			return amount;
		} catch (IllegalArgumentException e) {
			System.out.println(ERROR_MSG + e.getMessage());
			return ERROR_CODE;
		}
	}

	private int inputTransferToInt(String inputAmount) throws IllegalArgumentException {
		try {
			return Integer.parseInt(inputAmount);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(INT_TYPE_ERROR_MSG);
		}
	}

	private void validRange(int amount) {
		if (amount < 0) {
			throw new IllegalArgumentException(NEGATIVE_INT_ERROR_MSG);
		}
	}

	private void validIsDivisibleBy10(int amount) {
		if (amount % DIVISOR != 0) {
			throw new IllegalArgumentException(NOT_DIVISIBLE_BY_10_ERROR_MSG);
		}
	}
}
