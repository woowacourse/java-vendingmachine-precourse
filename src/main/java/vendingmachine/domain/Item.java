package vendingmachine.domain;

import vendingmachine.constants.Constant;

import static vendingmachine.constants.Constant.*;
import static vendingmachine.constants.Message.*;

public class Item {
	private final String name;
	private final int price;
	private int stock;

	public Item(String name, int price, int stock) {
		this.name = name;
		this.price = price;
		this.stock = stock;
	}

	public int order(int userMoney) {
		if (isEnoughMoney(userMoney)) {
			decreaseStockCount();
			return userMoney - price;
		}

		return userMoney;
	}

	private boolean isEnoughMoney(int userMoney) {
		return userMoney >= price;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public int remainedStock() {
		return stock;
	}

	public void decreaseStockCount() {
		if (isRunOutOfStock()) {
			throw new IllegalArgumentException(ERROR_NOT_ENOUGH_STOCK);
		}
		stock--;
	}

	private boolean isRunOutOfStock() {
		return stock == RUN_OUT_OF_STOCK;
	}
}
