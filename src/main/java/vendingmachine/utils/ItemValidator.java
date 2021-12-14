package vendingmachine.utils;

import static vendingmachine.utils.Constant.*;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ItemValidator {
	public static final String ERROR_EMPTY_ITEM = "[ERROR] 상품을 한 개이상 등록해주세요.";
	public static final String ERROR_NUMBER_OF_PROPERTIES = "[ERROR] 상품명과 가격, 수량 3가지 항목을 입력해주세요.";
	public static final String ERROR_ITEM_NAME_DUPLICATE = "[ERROR] 중복되는 상품명이 있습니다.";
	public static final String ERROR_NOT_INTEGER = "[ERROR] 상품 가격, 수량은 숫자로 입력해주세요.";
	public static final String ERROR_PRICE_UNDER_MINIMUM = "[ERROR] 상품 가격은 100원 이상으로 입력해주세요";
	public static final String ERROR_QUANTITY_NOT_POSITIVE = "[ERROR] 상품 수량은 1개 이상으로 입력해주세요";
	public static final String ERROR_PRICE_NOT_DIVIDE_BY_10 = "[ERROR] 상품 가격은 10원으로 나누어떨어져야 합니다.";

	private static List<String> itemNameList;

	public void validateItems(String inputValue) {
		StringTokenizer stringTokenizer = new StringTokenizer(inputValue, ITEMS_DELIMITER);
		isNotEmpty(stringTokenizer);
		itemNameList = new ArrayList<>();
		while (stringTokenizer.hasMoreTokens()) {
			validateItem(stringTokenizer.nextToken());
		}
	}

	private void isNotEmpty(StringTokenizer stringTokenizer) {
		if (stringTokenizer.countTokens() == 0) {
			throw new IllegalArgumentException(ERROR_EMPTY_ITEM);
		}
	}

	private void validateItem(String item) {
		item = item.replaceAll(START_BRACKET, "").replaceAll(END_BRACKET, "");
		StringTokenizer stringTokenizer = new StringTokenizer(item, ITEM_DELIMITER);
		checkItemProperties(stringTokenizer);

		String itemName = stringTokenizer.nextToken().trim();
		String itemPrice = stringTokenizer.nextToken().trim();
		String itemQuantity = stringTokenizer.nextToken().trim();

		checkItemName(itemName);
		checkItemPrice(itemPrice);
		checkItemQuantity(itemQuantity);
	}

	private void checkItemProperties(StringTokenizer stringTokenizer) {
		if (stringTokenizer.countTokens() != NUMBER_OF_ITEM_PROPERTIES) {
			throw new IllegalArgumentException(ERROR_NUMBER_OF_PROPERTIES);
		}
	}

	private void checkItemName(String itemName) {
		isDuplicateItemName(itemName);
	}

	private void checkItemPrice(String itemPrice) {
		isInteger(itemPrice);
		isOverMin(itemPrice);
		isDivideBy10(itemPrice);
	}

	private void checkItemQuantity(String itemQuantity) {
		isInteger(itemQuantity);
		isPositive(itemQuantity);
	}

	private void isDuplicateItemName(String itemName) {
		if (itemNameList.contains(itemName)) {
			throw new IllegalArgumentException(ERROR_ITEM_NAME_DUPLICATE);
		}
		itemNameList.add(itemName);
	}

	private void isInteger(String inputValue) {
		try {
			Integer.parseInt(inputValue);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ERROR_NOT_INTEGER);
		}
	}

	private void isOverMin(String itemPrice) {
		if (Integer.parseInt(itemPrice) < MINIMUM_PRICE) {
			throw new IllegalArgumentException(ERROR_PRICE_UNDER_MINIMUM);
		}
	}

	private void isDivideBy10(String itemPrice) {
		if (Integer.parseInt(itemPrice) % 10 != 0) {
			throw new IllegalArgumentException(ERROR_PRICE_NOT_DIVIDE_BY_10);
		}
	}

	private void isPositive(String itemQuantity) {
		if (Integer.parseInt(itemQuantity) <= 0) {
			throw new IllegalArgumentException(ERROR_QUANTITY_NOT_POSITIVE);
		}
	}

}
