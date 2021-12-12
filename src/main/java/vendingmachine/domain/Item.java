package vendingmachine.domain;

import vendingmachine.utils.DataParser;

public class Item {
	private static final int ZERO = 0;
	private static final int ATTRIBUTES_COUNT = 3;
	private static final String INSUFFICIENT_ATTRIBUTES = "[ERROR] 상품의 속성은 이름, 가격, 수량의 3개여야 합니다.";
	private static final String NOT_NUMBER_QUANTITY = "[ERROR] 상품의 수량은 숫자여야 합니다.";
	private static final String NOT_LEFT_QUANTITY = "[ERROR] 상품의 수량은 0 이상이어야 합니다.";

	private String name;
	private Money price;
	private int quantity;

	public Item(String[] data) {
		validateLength(data);
		name = data[0].trim();
		price = new Money(data[1]);
		quantity = DataParser.parseInt(data[2], NOT_NUMBER_QUANTITY);
		if (!quantityLeft()) {
			throw new IllegalArgumentException(NOT_LEFT_QUANTITY);
		}
	}

	private void validateLength(String[] data) {
		if (data.length != ATTRIBUTES_COUNT) {
			throw new IllegalArgumentException(INSUFFICIENT_ATTRIBUTES);
		}
	}

	private boolean quantityLeft() {
		return quantity > ZERO;
	}
}
