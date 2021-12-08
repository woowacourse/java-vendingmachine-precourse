package vendingmachine;

public class Amount {
	private static final int MINIMUM_UNIT = 10;
	private final int amount;

	private Amount(int amount) {
		validateRange(amount);
		validateMinimumUnit(amount);
		this.amount = amount;
	}

	public static Amount of(String amount) {
		int convertAmount = convert(amount);
		return new Amount(convertAmount);
	}

	private static int convert(String amount) {
		try {
			return Integer.parseInt(amount);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(Notification.AMOUNT_CONVERT_FAILURE.getMessage());
		}
	}

	private void validateMinimumUnit(int amount) {
		if(amount % MINIMUM_UNIT != 0) {
			throw new IllegalArgumentException(Notification.AMOUNT_SMALLER_MINIMUM_UNIT.getMessage());
		}
	}
	
	private void validateRange(int amount) {
		if (amount < 0) {
			throw new IllegalArgumentException(Notification.AMOUNT_EXCEED_RANGE.getMessage());
		}
	}

}
