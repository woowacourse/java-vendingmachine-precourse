package vendingmachine.billing;

public class MoneyValidator {
	private static final String NOT_INTEGER = "금액은 숫자만 입력이 가능합니다.";
	private static final String NOT_POSITIVE = "금액은 0보다 커야합니다.";
	private static final String NOT_DIVISIBLE = "금액은 10원으로 나누어떨어져야 합니다.";
	private static final int MINIMUM_DIVISIBLE_NUMBER = 10;
	private static final int ZERO = 0;

	public void validate(String money, String prefix) {
		validateInteger(money, prefix);
		validatePositive(Integer.parseInt(money), prefix);
		validateDivisible(Integer.parseInt(money), prefix);
	}

	private void validateInteger(String money, String prefix) {
		try {
			Integer.parseInt(money);
		} catch (IllegalArgumentException illegalArgumentException) {
			throw new IllegalArgumentException(prefix + NOT_INTEGER);
		}
	}

	private void validatePositive(int money, String prefix) {
		if (money <= ZERO) {
			throw new IllegalArgumentException(prefix + NOT_POSITIVE);
		}
	}

	private void validateDivisible(int money, String prefix) {
		if (Math.floorMod(money, MINIMUM_DIVISIBLE_NUMBER) != ZERO) {
			throw new IllegalArgumentException(prefix + NOT_DIVISIBLE);
		}
	}
}
