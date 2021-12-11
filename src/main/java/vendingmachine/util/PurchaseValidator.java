package vendingmachine.util;

import vendingmachine.domain.Balance;
import vendingmachine.domain.Items;

public class PurchaseValidator {
	private static final String ERROR = "[ERROR] ";
	private static final String NO_SUCH_ITEMS = "존재하지 않는 상품입니다.";
	private static final String SOLD_OUT = "해당 상품은 품절입니다.";
	private static final String NOT_ENOUGH_BALANCE = "잔액이 부족합니다.";

	public static void isValidPurchase(String itemName, Items items, Balance balance) {
		noSuchItem(itemName, items);
		isSoldOut(itemName, items);
		notEnoughBalance(itemName, items, balance);
	}

	private static void noSuchItem(String itemName, Items items) {
		if (items.noSuchItem(itemName)) {
			throw new IllegalArgumentException(ERROR + NO_SUCH_ITEMS);
		}
	}

	private static void isSoldOut(String itemName, Items items) {
		if (items.notEnoughItem(itemName)) {
			throw new IllegalArgumentException(ERROR + SOLD_OUT);
		}
	}

	private static void notEnoughBalance(String itemName, Items items, Balance balance) {
		if (items.notEnoughBalance(itemName, balance)) {
			throw new IllegalArgumentException(ERROR + NOT_ENOUGH_BALANCE);
		}
	}
}
