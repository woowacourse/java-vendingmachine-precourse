package vendingmachine.domain;

import java.util.Objects;

import vendingmachine.validation.PositiveIntegerValidation;
import vendingmachine.validation.Validator;

public class Money {
	private static final String UNIT = "원";
	public static final String NAME = "금액";

	private int amount;

	public Money(int amount) {
		this.amount = Validator.validate(NAME, amount, new PositiveIntegerValidation());
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
		return amount + UNIT;
	}
}
