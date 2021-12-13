package vendingmachine.domain.money;

import java.util.Objects;

import vendingmachine.constant.Notification;
import vendingmachine.domain.quantity.Quantity;
import vendingmachine.exception.OutOfBoundException;

public class Money implements Comparable<Money> {
	private static final int MINIMUM_UNIT = 10;
	private int amount;

	private Money(int amount) {
		validateRange(amount);
		validateMinimumUnit(amount);
		this.amount = amount;
	}

	public static Money of(String amount) {
		int convertAmount = convert(amount);
		return new Money(convertAmount);
	}

	public static Money of(int amount) {
		return new Money(amount);
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

	public void spend(Money money) {
		if (!isSpendable(money)) {
			throw new OutOfBoundException(Notification.AMOUNT_NOT_SPEND.getMessage());
		}
		this.amount -= money.amount;
	}

	public void spend(Money money, Quantity quantity) {
		if (!isMultipliable(money, quantity)) {
			throw new OutOfBoundException(Notification.AMOUNT_NOT_SPEND.getMessage());
		}
		spend(Money.of(money.getAmount() * quantity.getCount()));
	}

	public void earn(Money money) {
		if (!isAddable(money)) {
			throw new OutOfBoundException(Notification.AMOUNT_NOT_EARN.getMessage());
		}
		this.amount += money.amount;
	}

	private boolean isMultipliable(Money money, Quantity quantity) {
		try {
			Math.addExact(money.amount, quantity.getCount());
			return true;
		} catch (ArithmeticException e) {
			return false;
		}
	}

	private boolean isAddable(Money money) {
		try {
			Math.addExact(this.amount, money.amount);
			return true;
		} catch (ArithmeticException e) {
			return false;
		}
	}

	public boolean isSpendable(Money money) {
		return this.amount >= money.amount;
	}

	public boolean isSpendable(int amount) {
		return this.amount >= amount;
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
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Money compareMoney = (Money)o;
		return amount == compareMoney.amount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount);
	}

	@Override
	public String toString() {
		return amount + "원";
	}

	@Override
	public int compareTo(Money o) {
		return Integer.compare(this.amount, o.amount);
	}

}
