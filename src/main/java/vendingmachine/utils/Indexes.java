package vendingmachine.utils;

public enum Indexes {
	NAME_INDEX(0),
	PRICE_INDEX(1),
	AMOUNT_INDEX(2);

	private final int value;

	Indexes(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}
}
