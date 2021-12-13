package vendingmachine.utill;

public class InputMoneyValidator {
	private static final int ERROR_CODE = -1;
	private static final int DIVISOR_10 = 10;

	public static void validateIsDivisibleBy10(int amount) throws IllegalArgumentException {
		if (amount % DIVISOR_10 != 0) {
			throw new IllegalArgumentException(ErrorMsgConst.NOT_DIVISIBLE_BY_10_ERROR_MSG);
		}
	}

	public int validateMoney(String inputAmount) {
		try {
			int amount = transferToInt(inputAmount);
			validateRange(amount);
			validateIsDivisibleBy10(amount);
			return amount;
		} catch (IllegalArgumentException e) {
			System.out.println(ErrorMsgConst.ERROR_MSG + e.getMessage());
			return ERROR_CODE;
		}
	}

	private int transferToInt(String inputAmount) throws IllegalArgumentException {
		try {
			return Integer.parseInt(inputAmount);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ErrorMsgConst.INT_TYPE_ERROR_MSG);
		}
	}

	private void validateRange(int amount) throws IllegalArgumentException {
		if (amount < 0) {
			throw new IllegalArgumentException(ErrorMsgConst.NEGATIVE_INT_ERROR_MSG);
		}
	}
}
