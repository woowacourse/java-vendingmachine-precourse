package vendingmachine;

import java.util.Objects;

public class Amount {
	private static final int MINIMUM_UNIT = 10;
	private int amount;

	private Amount(int amount) {
		validateRange(amount);
		validateMinimumUnit(amount);
		this.amount = amount;
	}

	public static Amount of(String amount) {
		int convertAmount = convert(amount);
		return new Amount(convertAmount);
	}

	public static Amount of(int amount) {
		return new Amount(amount);
	}

	private static int convert(String amount) {
		try {
			return Integer.parseInt(amount);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(Notification.AMOUNT_CONVERT_FAILURE.getMessage());
		}
	}

	public boolean isZero() {
		return amount == 0;
	}

	public void spend(Amount amount) {
		if (isSpendable(amount)) {
			this.amount -= amount.amount;
		}
		// 소비할 수 없을 때 알려야한다.
	}

	public boolean isSpendable(Amount amount) {
		return this.amount >= amount.amount;
	}

	public int getAmount() {
		return this.amount;
	}

	private void validateMinimumUnit(int amount) {
		if (amount % MINIMUM_UNIT != 0) {
			throw new IllegalArgumentException(Notification.AMOUNT_SMALLER_MINIMUM_UNIT.getMessage());
		}
	}

	private void validateRange(int amount) {
		if (amount < 0) {
			throw new IllegalArgumentException(Notification.AMOUNT_EXCEED_RANGE.getMessage());
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Amount amount1 = (Amount)o;
		return amount == amount1.amount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount);
	}
}
