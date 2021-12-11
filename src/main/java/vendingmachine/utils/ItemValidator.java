package vendingmachine.utils;

import static vendingmachine.utils.Constant.*;

import java.util.StringTokenizer;

public class ItemValidator {
	public static final String ERROR_EMPTY_ITEM = "[ERROR] 상품을 한 개이상 등록해주세요.";
	public static final String ERROR_NUMBER_OF_PROPERTIES = "[ERROR] 상품명과 가격, 수량 3가지 항목을 입력해주세요.";
	public static final String ERROR_NOT_INTEGER = "[ERROR] 상품 가격, 수량은 숫자로 입력해주세요.";
	public static final String ERROR_PRICE_UNDER_100 = "[ERROR] 상품 가격은 100원 이상으로 입력해주세요";
	public static final String ERROR_QUANTITY_NOT_POSITIVE = "[ERROR] 상품 수량은 1개 이상으로 입력해주세요";
	public static final String ERROR_PRICE_NOT_DIVIDE_BY_10 = "[ERROR] 상품 가격은 10원으로 나누어떨어져야 합니다.";

	public void validateItems(String inputValue) {
		StringTokenizer stringTokenizer = new StringTokenizer(inputValue, ITEMS_DELIMITER);
		if (stringTokenizer.countTokens() == 0) {
			throw new IllegalArgumentException(ERROR_EMPTY_ITEM);
		}
		while (stringTokenizer.hasMoreTokens()) {
			validateItem(stringTokenizer.nextToken());
		}
	}

	private void validateItem(String item) {
		item = item.replaceAll(START_BRACKET, "").replaceAll(END_BRACKET, "");
		StringTokenizer stringTokenizer = new StringTokenizer(item, ITEM_DELIMITER);
		checkProperties(stringTokenizer);
		String itemName = stringTokenizer.nextToken().trim();
		String itemPrice = stringTokenizer.nextToken().trim();
		String itemQuantity = stringTokenizer.nextToken().trim();
		checkItemPrice(itemPrice);
		checkItemQuantity(itemQuantity);
	}

	private void checkProperties(StringTokenizer stringTokenizer) {
		if (stringTokenizer.countTokens() != NUMBER_OF_ITEM_PROPERTIES) {
			throw new IllegalArgumentException(ERROR_NUMBER_OF_PROPERTIES);
		}
	}

	private void checkItemPrice(String itemPrice) {
		try {
			int price = Integer.parseInt(itemPrice);
			if (price < MINIMUM_PRICE) {
				throw new IllegalArgumentException(ERROR_PRICE_UNDER_100);
			}
			if (price % 10 != 0) {
				throw new IllegalArgumentException(ERROR_PRICE_NOT_DIVIDE_BY_10);
			}
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ERROR_NOT_INTEGER);
		}
	}

	private void checkItemQuantity(String itemQuantity) {
		try {
			int quantity = Integer.parseInt(itemQuantity);
			if (quantity <= 0) {
				throw new IllegalArgumentException(ERROR_QUANTITY_NOT_POSITIVE);
			}
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ERROR_NOT_INTEGER);
		}
	}

}
