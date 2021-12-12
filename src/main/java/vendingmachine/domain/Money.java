package vendingmachine.domain;

import vendingmachine.utils.DataParser;

public class Money {
	private static final int ZERO = 0;
	private static final int MIN = 10; // 가장 작은 동전 단위
	private static final String INVALID_MONEY = "[ERROR] 올바르지 않은 금액 입력입니다.";
	private static final String NOT_NUMBER = "[ERROR] 금액은 숫자여야 합니다.";
	private static final String WON = "원";

	private int amount;

	public Money(String input) {
		int parsedValue = DataParser.parseInt(input, NOT_NUMBER);
		validate(parsedValue);
		this.amount = parsedValue;
	}

	private void validate(int amount) {
		if (!dividedByMin(amount) || !greaterThanZero(amount)) {
			throw new IllegalArgumentException(INVALID_MONEY);
		}
	}

	private boolean dividedByMin(int amount) {
		return amount % MIN == 0;
	}

	private boolean greaterThanZero(int amount) {
		return amount > ZERO;
	}

	public int getAmount() {
		return amount;
	}

	@Override
	public String toString() {
		return getAmount() + WON;
	}
}
