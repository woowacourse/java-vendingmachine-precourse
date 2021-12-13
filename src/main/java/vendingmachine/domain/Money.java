package vendingmachine.domain;

import java.util.Objects;

import vendingmachine.validation.PositiveIntegerValidation;
import vendingmachine.validation.Validator;

public class Money {
	public static final Money ZERO = new Money(0);
	private static final String CURRENCY = "원";
	public static final String NAME = "금액";

	private int amount;

	public Money(int amount) {
		this.amount = Validator.validate(NAME, amount, new PositiveIntegerValidation());
	}

	public Money plus(Money other) {
		return new Money(this.amount + other.amount);
	}

	public Money minus(Money other) {
		return new Money(this.amount - other.amount);
	}

	public Money multiply(int other) {
		int amount = this.amount;
		return new Money(amount * other);
	}

	public boolean isLessThan(Money other) {
		return this.amount < other.amount;
	}

	public boolean isGreaterThan(Money other) {
		return this.amount > other.amount;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Money money = (Money)o;
		return amount == money.amount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount);
	}

	@Override
	public String toString() {
		return amount + CURRENCY;
	}

}
