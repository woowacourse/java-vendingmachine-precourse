package vendingmachine.domain;

public class Money {
	private int money;

	public Money(String value) {
		validateNumberFormat(value);
		int money = Integer.parseInt(value);
		validateRange(money);
		validateDivisibleBy10(money);
		this.money = money;
	}

	public int get() {
		return money;
	}

	private void validateNumberFormat(String value) {
		try {
			Integer.parseInt(value);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException();
		}
	}

	private void validateRange(int money) {
	}

	private void validateDivisibleBy10(int money) {
	}
}
