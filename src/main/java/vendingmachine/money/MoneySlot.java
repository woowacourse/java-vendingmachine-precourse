package vendingmachine.money;

public class MoneySlot {
	private static final int MINIMUM_DIVISIBLE_NUMBER = 10;
	private static final int ZERO = 0;
	private static final String NOT_INTEGER = "자판기에 투입하는 금액은 숫자만 입력이 가능합니다.";
	private static final String NOT_POSITIVE = "자판기에 투입하는 금액은 0보다 커야합니다.";
	private static final String NOT_DIVISIBLE = "자판기에 투입하는 금액은 10원으로 나누어떨어져야 합니다.";
	private static final String NOT_ENOUGH_MONEY = "잔액 부족으로 해당 상품을 구매할 수 없습니다.";

	private int money;

	public void insert(String money) {
		validate(money);
	}

	private void validate(String money) {
		validateInteger(money);
		validatePositive();
		validateDivisible();
	}

	private void validateInteger(String money) {
		try {
			this.money = Integer.parseInt(money);
		} catch (IllegalArgumentException illegalArgumentException) {
			throw new IllegalArgumentException(NOT_INTEGER);
		}
	}

	private void validatePositive() {
		if (money <= ZERO) {
			throw new IllegalArgumentException(NOT_POSITIVE);
		}
	}

	private void validateDivisible() {
		if (Math.floorMod(money, MINIMUM_DIVISIBLE_NUMBER) != ZERO) {
			throw new IllegalArgumentException(NOT_DIVISIBLE);
		}
	}

	public int getRemainMoney() {
		return money;
	}

	public void payProductValue(int value) {
		validateEnoughMoney(value);
		money -= value;
	}

	private void validateEnoughMoney(int value) {
		if (money < value) {
			throw new IllegalArgumentException(NOT_ENOUGH_MONEY);
		}
	}
}
