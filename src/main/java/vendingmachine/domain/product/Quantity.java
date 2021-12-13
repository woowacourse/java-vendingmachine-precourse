package vendingmachine.domain.product;

public class Quantity {
	private static final int QUANTITY_ZERO = 0;
	private static final int QUANTITY_MINUS = -1;
	private static final String ERROR_QUANTITY_NOT_NUMBER = "수량이 숫자가 아닙니다.";
	private static final String ERROR_QUANTITY_ZERO = "수량이 0인 경우 구매하실 수 없습니다.";

	private final int quantity;

	private Quantity(int quantity) {
		this.quantity = quantity;
	}

	public static Quantity from(String quantity) {
		isValidateNumber(quantity);
		return new Quantity(Integer.parseInt(quantity));
	}

	private static void isValidateNumber(String quantity) {
		try {
			Integer.parseInt(quantity);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ERROR_QUANTITY_NOT_NUMBER);
		}
	}

	public boolean isValidateQuantityZero() {
		return this.quantity == QUANTITY_ZERO;
	}

	public Quantity minus() {
		if (this.quantity == QUANTITY_ZERO) {
			throw new IllegalArgumentException(ERROR_QUANTITY_ZERO);
		}
		return new Quantity(this.quantity + QUANTITY_MINUS);
	}
}
