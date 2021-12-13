package vendingmachine.domain;

import static vendingmachine.resource.MessageResource.*;

import vendingmachine.utils.NumericUtils;

public class Product {
	private static final int MIN_AMOUNT = 100;
	private static final int DIVIDE_NUM = 10;

	private final String name;
	private final int price;
	private final int count;

	public Product(String name, int price, int count) {
		check(price, count);
		this.name = name;
		this.price = price;
		this.count = count;
	}

	private void check(int price, int count) {
		if (price < MIN_AMOUNT || price % DIVIDE_NUM != 0) {
			throw new IllegalArgumentException(ERROR_PRODUCT_PRICE_NOT_VALID);
		}
		if (count < 0) {
			throw new IllegalArgumentException(ERROR_PRODUCT_COUNT_IS_NOT_POSITIVE_INT);
		}
	}

	public Product(String[] split) {
		this(split[0], NumericUtils.parseInt(split[1]), NumericUtils.parseInt(split[2]));
	}
}
