package vendingmachine.quantity;

import vendingmachine.Notification;

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

	private static int intValue(String count) {
		try {
			return Integer.parseInt(count);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(Notification.QUANTITY_INVALID_RANGE.getMessage());
		}
	}

	public Quantity up() {
		if (isMaximum()) {
			throw new ArithmeticException(Notification.QUANTITY_INVALID_RANGE.getMessage());
		}
		count++;
		return this;
	}

	public Quantity down() {
		if (isZero()) {
			throw new ArithmeticException(Notification.QUANTITY_INVALID_RANGE.getMessage());
		}
		count--;
		return this;
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

	@Override
	public String toString() {
		return count+"개";
	}
}
