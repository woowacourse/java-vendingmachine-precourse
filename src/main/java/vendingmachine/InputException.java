package vendingmachine;

import java.util.Arrays;

public class InputException {
	private static final String IS_INTEGER_ERROR_MSG = "[ERROR] 금액은 숫자여야 합니다.";
	private static final String IS_POSITIVE_INTEGER_ERROR_MSG = "[ERROR] 금액은 0보다 커야 합니다.";
	private static final String IS_MULTIPLICATION_OF_TEN_ERROR_MSG = "[ERROR] 금액은 10으로 나누어 떨어져야 합니다.";

	private static final String ITEM_LENGTH_ERROR_MSG = "[ERROR] [상품명, 가격, 수량] 형식의 값만을 입력해야 합니다.";
	private static final String ITEM_PRICE_ERROR_MSG = "[ERROR] 상품 가격은 100원 이상이어야 합니다.";
	private static final String ITEM_STOCK_IS_INTEGER_ERROR_MSG = "[ERROR] 상품 수량은 숫자여야 합니다.";
	private static final String ITEM_STOCK_IS_POSITIVE_ERROR_MSG = "[ERROR] 상품 수량은 0보다 커야 합니다.";

	private static final String CAN_BUY = "[ERROR] 리스트에 없는 상품입니다.";

	public static void checkAmount(String amount) {
		isInteger(amount);
		isPositiveInteger(amount);
		isMultiplicationOfTen(amount);
	}

	public static void checkItem(String[] items) {
		itemLengthCheck(items);
		itemPriceCheck(items);
		itemStockCheck(items);
	}

	public static void checkInputMoney(String Money) {
		isInteger(Money);
		isPositiveInteger(Money);
		isMultiplicationOfTen(Money);
	}

	public static void isInteger(String amount) {
		try {
			Integer.parseInt(amount);
		} catch (Exception e) {
			throw new IllegalArgumentException(IS_INTEGER_ERROR_MSG);
		}
	}

	public static void isPositiveInteger(String amount) {
		if (Integer.parseInt(amount) <= 0) {
			throw new IllegalArgumentException(IS_POSITIVE_INTEGER_ERROR_MSG);
		}
	}

	public static void isMultiplicationOfTen(String amount) {
		if (Integer.parseInt(amount) % 10 != 0) {
			throw new IllegalArgumentException(IS_MULTIPLICATION_OF_TEN_ERROR_MSG);
		}
	}

	public static void itemLengthCheck(String[] items) {
		for (int i = 0; i < items.length; i++) {
			String[] item = items[i].replace("[", "").replace("]", "").replace(" ", "").split(",");
			if (item.length != 3) {
				throw new IllegalArgumentException(ITEM_LENGTH_ERROR_MSG);
			}
		}
	}

	public static void itemPriceCheck(String[] items) {
		for (int i = 0; i < items.length; i++) {
			String[] item = items[i].replace("[", "").replace("]", "").replace(" ", "").split(",");
			checkAmount(item[1]);
			if (Integer.parseInt(item[1]) < 100) {
				throw new IllegalArgumentException(ITEM_PRICE_ERROR_MSG);
			}
		}
	}

	public static void itemStockCheck(String[] items) {
		for (int i = 0; i < items.length; i++) {
			String[] item = items[i].replace("[", "").replace("]", "").replace(" ", "").split(",");
			try {
				Integer.parseInt(item[2]);
			} catch (Exception e) {
				throw new IllegalArgumentException(ITEM_STOCK_IS_INTEGER_ERROR_MSG);
			}

			if (Integer.parseInt(item[2]) <= 0) {
				throw new IllegalArgumentException(ITEM_STOCK_IS_POSITIVE_ERROR_MSG);
			}
		}
	}

	public static int canBuy(Items[] items, String item) {
		boolean canBuy = false;
		int itemsIndex = -1;

		for (int i = 0; i < items.length; i++) {
			if (item.equals(items[i].getName())) {
				canBuy = true;
				itemsIndex = i;
			}
		}

		if (!canBuy) {
			throw new IllegalArgumentException(CAN_BUY);
		}
		return itemsIndex;
	}
}
