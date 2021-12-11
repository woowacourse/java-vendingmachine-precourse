package vendingmachine.domain;

public class Money {
	private static final int ZERO = 0;
	private static final int MIN = 10; // 가장 작은 동전 단위
	private static final String INVALID_MONEY = "[ERROR] 올바르지 않은 금액 입력입니다.";

	private int amount;

	public Money(String input) {
		int parsedValue = parseInt(input);
		validate(parsedValue);
		this.amount = parsedValue;
	}

	private int parseInt(String input) {
		try {
			return Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(INVALID_MONEY);
		}
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
}
