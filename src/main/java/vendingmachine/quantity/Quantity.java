package vendingmachine.quantity;

import vendingmachine.Money;
import vendingmachine.Notification;
import vendingmachine.exception.OutOfBoundException;

public class Quantity {
	private static final int MINIMUM_QUANTITY = 0;
	private static final int MAXIMUM_QUANTITY = Integer.MAX_VALUE;

	private int count;

	private Quantity() {
		this.count = MINIMUM_QUANTITY;
	}

	private Quantity(int count) {
		validateRange(count);
		this.count = count;
	}

	public static Quantity from() {
		return new Quantity();
	}

	public static Quantity of(String count) {
		return new Quantity(intValue(count));
	}

	public static Quantity of(int count) {
		return new Quantity(count);
	}

	private static int intValue(String count) {
		try {
			return Integer.parseInt(count);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(Notification.QUANTITY_INVALID_RANGE.getMessage());
		}
	}

	public Quantity up() {
		if (isMaximum()) {
			throw new OutOfBoundException(Notification.QUANTITY_EXCEED_RANGE.getMessage());
		}
		count++;
		return this;
	}

	public Quantity up(Quantity quantity) {
		if(!isIncrease(quantity)) {
			throw new OutOfBoundException(Notification.QUANTITY_EXCEED_RANGE.getMessage());
		}
		count += quantity.count;
		return this;
	}

	public Quantity down() {
		if (isZero()) {
			throw new OutOfBoundException(Notification.QUANTITY_EXCEED_RANGE.getMessage());
		}
		count--;
		return this;
	}

	public Quantity down(Quantity quantity) {
		if(!isDecrease(quantity)) {
			throw new OutOfBoundException(Notification.QUANTITY_EXCEED_RANGE.getMessage());
		}
		count -= quantity.count;
		return this;
	}

	private boolean isIncrease(Quantity quantity) {
		try {
			Math.addExact(this.count, quantity.getCount());
			return true;
		} catch (ArithmeticException e) {
			return false;
		}
	}

	private boolean isDecrease(Quantity quantity) {
		return count - quantity.count >= MINIMUM_QUANTITY;
	}

	public boolean isZero() {
		return count == MINIMUM_QUANTITY;
	}

	private boolean isMaximum() {
		return count == MAXIMUM_QUANTITY;
	}

	private void validateRange(int count) {
		if (count < MINIMUM_QUANTITY) {
			throw new IllegalArgumentException(Notification.QUANTITY_INVALID_RANGE.getMessage());
		}
	}

	public int getCount() {
		return count;
	}

	@Override
	public String toString() {
		return count+"개";
	}
}
