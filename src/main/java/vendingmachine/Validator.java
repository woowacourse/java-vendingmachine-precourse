package vendingmachine;

import java.util.Map;
import java.util.regex.Pattern;

/**
 * 사용자의 입력값에 대한 검증을 수행하는 model class
 *
 * @author YJGwon
 * @version 1.0
 * @since 1.0
 */
public class Validator {
	private static final int AMOUNT_UNIT = 10;
	private static final int MIN_PRICE = 100;
	private static final int MIN_COUNT = 1;

	// 정규식으로 더 자세한 검증을 할 수도 있지만, 사용자에게 각각의 예외 경우에 대한 자세한 안내를 주기 위해 최소한의 형식만 검사
	// 상품명 공백, 가격과 수량 범위까지 검사하는 정규식 : "^\\[\\S+,[1-9][0-9]{3,},[1-9][0-9]*]$"
	private static final String ITEM_REGEX = "^\\[\\S+,[0-9]+,[0-9]+]$";

	private static final String NOT_NUMBER_ERROR = "숫자로만 입력해야 합니다.";
	private static final String CAN_NOT_BE_DIVIDED_BY_10_ERROR = "금액은 10원 단위로 입력해야 합니다.";
	private static final String MINUS_ERROR = "음수는 입력할 수 없습니다.";
	private static final String ITEM_FORMAT_ERROR = "형식에 맞게 입력하세요([상품명,가격,수량];[]...)";
	private static final String BLANK_ERROR = "상품명은 공백일 수 없습니다.";
	private static final String DUPLICATE_ITEM_ERROR = "상품명이 중복됩니다.";
	private static final String PRICE_RANGE_ERROR = "상품 가격은 100 이상이어야 합니다.";
	private static final String COUNT_RANGE_ERROR = "상품 수량은 1 이상이어야 합니다.";
	private static final String NO_SUCH_ITEM_ERROR = "존재하지 않거나 품절된 상품입니다.";

	public int validateAmount(String input) {
		int amount = stringToInteger(input);
		checkMinus(amount);
		checkUnit(amount);
		return amount;
	}

	public void validateItemFormat(String input) {
		if (Pattern.matches(ITEM_REGEX, input)) {
			return;
		}
		throw new IllegalArgumentException(ITEM_FORMAT_ERROR);
	}

	public String validateNewItemName(Map<String, Item> items, String name) {
		checkBlank(name);
		checkDuplicateItemName(items, name);
		return name;
	}

	public int validateItemPrice(String input) {
		int price = stringToInteger(input);
		checkPriceRange(price);
		checkUnit(price);
		return price;
	}

	public int validateItemCount(String input) {
		int count = stringToInteger(input);
		checkCountRange(count);
		return count;
	}

	public String validateBuyingItem(String name, ItemManager itemManager) {
		if(itemManager.hasItem(name)) {
			return name;
		}
		throw new IllegalArgumentException(NO_SUCH_ITEM_ERROR);
	}

	private int stringToInteger(String string) {
		try {
			return Integer.parseInt(string);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(NOT_NUMBER_ERROR);
		}
	}

	private void checkMinus(int number) {
		if (number >= 0) {
			return;
		}
		throw new IllegalArgumentException(MINUS_ERROR);
	}

	private void checkUnit(int number) {
		if ((number % AMOUNT_UNIT) == 0) {
			return;
		}
		throw new IllegalArgumentException(CAN_NOT_BE_DIVIDED_BY_10_ERROR);
	}

	private void checkBlank(String string) {
		if (string.trim().length() > 0) {
			return;
		}
		throw new IllegalArgumentException(BLANK_ERROR);
	}

	private void checkDuplicateItemName(Map<String, Item> items, String name) {
		if (items.containsKey(name)) {
			throw new IllegalArgumentException(DUPLICATE_ITEM_ERROR);
		}
	}

	private void checkPriceRange(int price) {
		if (price >= MIN_PRICE) {
			return;
		}
		throw new IllegalArgumentException(PRICE_RANGE_ERROR);
	}

	private void checkCountRange(int count) {
		if (count >= MIN_COUNT) {
			return;
		}
		throw new IllegalArgumentException(COUNT_RANGE_ERROR);
	}
}
