package vendingmachine.domain;

import vendingmachine.utils.Constant;
import vendingmachine.utils.ErrorMessage;

public class Product {
	private final String name;
	private final int amount;
	private int count;

	public Product(String name, int amount, int count) {
		isAmount(amount);
		isCount(count);

		this.name = name;
		this.amount = amount;
		this.count = count;
	}

	public void isAmount(int amount) {
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

	public void isCount(int count) {
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

	public void buy(VendingMachine vendingMachine) {
		this.count--;
		vendingMachine.buy(this.amount);
	}
}
