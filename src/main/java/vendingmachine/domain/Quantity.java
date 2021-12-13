package vendingmachine.domain;

import vendingmachine.validation.PositiveIntegerValidation;
import vendingmachine.validation.Validator;

public class Quantity {
	private static final String UNIT = "개";
	public static final String NAME = "수량";
	public static final Quantity ZERO = new Quantity(0);
	public static final Quantity ONE = new Quantity(1);

	private int count;

	public Quantity(int count) {
		Validator.validate("개수", count, new PositiveIntegerValidation());
		this.count = count;
	}

	public Quantity plus(Quantity other) {
		return new Quantity(this.count + other.count);
	}

	@Override
	public String toString() {
		return count + UNIT;
	}
}
