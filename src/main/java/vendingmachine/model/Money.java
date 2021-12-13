package vendingmachine.model;

import static java.lang.String.*;

public class Money implements Comparable<Money> {
	private static final int MIN = 0;
	private static final String AMOUNT_LOWER_ERROR = "[ERROR] 금액은 음수일 수 없습니다.";
	private static final int UNIT = 10;
	private static final String UNIT_INVALID_ERROR = format("[ERROR] 금액은 %d으로 나누어 떨어져야 합니다.", UNIT);

	private int amount;

	private Money(int amount) {
		checkValidation(amount);
		this.amount = amount;
	}

	private void checkValidation(int amount) {
		checkLowerLimit(amount);
		checkDivideBy10(amount);
	}

	private void checkLowerLimit(int amount) {
		if (amount < MIN) {
			throw new IllegalArgumentException(AMOUNT_LOWER_ERROR);
		}
	}

	private void checkDivideBy10(int amount) {
		if (amount % UNIT != 0) {
			throw new IllegalArgumentException(UNIT_INVALID_ERROR);
		}
	}

	public static Money from(int amount) {
		return new Money(amount);
	}

	public static Money from(String amount) {
		return new Money(Integer.parseInt(amount));
	}

	public int getAmount() {
		return amount;
	}

	public boolean isValuableThan(Money other) {
		return amount >= other.amount;
	}

	public boolean isRemain() {
		return amount > MIN;
	}

	public void use(Money other) {
		this.amount -= other.amount;
	}

	public Money totalAmountOfCount(int count) {
		return new Money(amount * count);
	}

	public int getMaxCountOfCoin(Money coinAmount) {
		return this.amount / coinAmount.amount;
	}

	@Override
	public int compareTo(Money o) {
		return amount - o.amount;
	}

	@Override
	public String toString() {
		return String.valueOf(amount);
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Money money = (Money)o;
		return amount == money.amount;
	}

	@Override
	public int hashCode() {
		return amount;
	}
}
