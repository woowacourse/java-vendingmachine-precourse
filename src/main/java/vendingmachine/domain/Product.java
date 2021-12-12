package vendingmachine.domain;

import vendingmachine.utils.Constant;
import vendingmachine.utils.ErrorMessage;

public class Product {
	private final String name;
	private final int amount;
	private int count;

	public Product(String[] input) {
		isAmount(input);
		isCount(input);

		this.name = input[Constant.PRODUCT_NAME_INDEX];
		this.amount = Integer.parseInt(input[Constant.PRODUCT_AMOUNT_INDEX]);
		this.count = Integer.parseInt(input[Constant.PRODUCT_COUNT_INDEX]);
	}

	public void isAmount(String[] input) {
		int amount;
		try {
			amount = Integer.parseInt(input[Constant.PRODUCT_AMOUNT_INDEX]);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ErrorMessage.COMMON + ErrorMessage.PRODUCT_AMOUNT_NUM);
		}
		if (amount < Constant.PRODUCT_AMOUNT_MIN) {
			throw new IllegalArgumentException(ErrorMessage.COMMON + ErrorMessage.PRODUCT_AMOUNT_MIN);
		}
		if (amount > Constant.PRODUCT_AMOUNT_MAX) {
			throw new IllegalArgumentException(ErrorMessage.COMMON + ErrorMessage.PRODUCT_AMOUNT_MAX);
		}
		if (amount % Constant.PRODUCT_AMOUNT_DIVIDE != Constant.PRODUCT_AMOUNT_REMAINDER) {
			throw new IllegalArgumentException(ErrorMessage.COMMON + ErrorMessage.PRODUCT_AMOUNT_DIVIDE);
		}
	}

	public void isCount(String[] input) {
		int count;
		try {
			count = Integer.parseInt(input[2]);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ErrorMessage.COMMON + ErrorMessage.PRODUCT_COUNT_NUM);
		}
		if (count < Constant.PRODUCT_COUNT_MIN) {
			throw new IllegalArgumentException(ErrorMessage.COMMON + ErrorMessage.PRODUCT_COUNT_MIN);
		}
		if (count > Constant.PRODUCT_COUNT_MAX) {
			throw new IllegalArgumentException(ErrorMessage.COMMON + ErrorMessage.PRODUCT_COUNT_MAX);
		}
	}

	public String getName() {
		return name;
	}

	public int getAmount() {
		return this.amount;
	}

	public boolean isEmpty() {
		return this.count == 0;
	}

	public boolean isBuy(int enteredAmount) {
		return this.amount <= enteredAmount;
	}

	public void buy() {
		this.count--;
	}
}
