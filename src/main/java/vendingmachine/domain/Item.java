package vendingmachine.domain;

import static vendingmachine.constants.Constant.*;
import static vendingmachine.constants.Message.*;

import java.util.List;

import vendingmachine.utils.Parser;
import vendingmachine.utils.Validator;

public class Item {
	private final String name;
	private final int price;
	private int stock;

	public Item(String name, int price, int stock) {
		this.name = name;
		this.price = price;
		this.stock = stock;
	}

	public static Item registerItem(String[] detailInfo, List<Item> registeredItems) {
		String name = detailInfo[0];
		int price = Parser.makeInteger(detailInfo[1]);
		int stock = Parser.makeInteger(detailInfo[2]);
		checkValidation(name, price, stock, registeredItems);

		return new Item(name, price, stock);
	}

	private static void checkValidation(String registerName, int price, int stock, List<Item> registeredItems) {
		Validator.validateAddingItemName(registerName, registeredItems);
		Validator.validatePrice(price);
		Validator.validateStock(stock);
	}

	public boolean canPurchase(int userMoney) {
		return isEnoughMoney(userMoney) && !isRunOutOfStock();
	}

	public int order(int userMoney) {
		if (isEnoughMoney(userMoney)) {
			decreaseStockCount();
			return userMoney - price;
		}

		throw new IllegalArgumentException(ERROR_NOT_ENOUGH_MONEY);
	}

	private boolean isEnoughMoney(int userMoney) {
		return userMoney >= price;
	}

	public boolean isSameName(String name) {
		return this.name.equals(name);
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
