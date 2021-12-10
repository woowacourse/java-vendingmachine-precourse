package vendingmachine;

public class InputValidator {
	private static final String INVALID_TYPE_OF_HOLDING_AMOUNT_MESSAGE = "보유 금액은 숫자만 가능합니다.";
	private static final String INVALID_RANGE_OF_HOLDING_AMOUNT_MESSAGE = "보유 금액은 10으로 나누어 떨어져야 합니다.";
	private static final int UNIT_OF_HOLDING_MONEY = 10;
	private static final int ZERO = 0;

	public static void checkIsValidHoldingAmount(String amount) {
		for (int i = 0; i < amount.length(); i++) {
			if (!Character.isDigit(amount.charAt(i))) {
				throw new IllegalArgumentException(INVALID_TYPE_OF_HOLDING_AMOUNT_MESSAGE);
			}
		}
		if (Integer.parseInt(amount) % UNIT_OF_HOLDING_MONEY > ZERO) {
			throw new IllegalArgumentException(INVALID_RANGE_OF_HOLDING_AMOUNT_MESSAGE);
		}
	}
}
