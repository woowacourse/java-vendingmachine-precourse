package vendingmachine;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import vendingmachine.domain.Balance;
import vendingmachine.domain.Items;

public class Validation {
	private static final String ERROR = "[ERROR] ";
	private static final String NOT_NUMBER_ERROR = "금액은 숫자여야 합니다.";
	private static final String NOT_DIVIDABLE_ERROR = "금액은 10원 단위로 나누어져야 합니다.";
	private static final String NOT_POSITIVE_ERROR = "금액은 양수여야 합니다.";
	private static final String BLANK = "";
	private static final String NO_ITEMS_ERROR = "상품이 입력되지 않았습니다.";
	private static final String ITEM_DIVIDER = ";";
	private static final String REGEX = "\\[[a-zA-Z0-9가-힣]+,\\d{3,},\\d+\\]";
	private static final String NOT_VALID_FORMAT = "입력 형식이 잘못되었습니다.";
	private static final String INFO_DIVIDER = ",";
	private static final String NOT_VALID_PRICE = "상품 가격은 10원 단위로 나누어져야 합니다.";
	private static final String NOT_VALID_QUANTITY = "상품 수량은 1개 이상이어야 합니다.";
	private static final String NOTHING_TO_BUY = "투입하신 금액이 부족합니다.";
	private static final String NO_SUCH_ITEMS = "존재하지 않는 상품입니다.";
	private static final String SOLD_OUT = "해당 상품은 품절입니다.";
	private static final String NOT_ENOUGH_BALANCE = "잔액이 부족합니다.";

	private static final int TEN_WON = 10;
	private static final int ZERO_WON = 0;
	private static final int EMPTY = 0;
	private static final int ITEM_PACKAGE = 1;
	private static final int PRICE = 1;
	private static final int QUANTITY = 2;

	public static int isValidBalance(String input) {
		int balance = isDigit(input);
		isDividable(balance);
		isPositive(balance);
		return balance;
	}

	private static int isDigit(String input) {
		try {
			return Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ERROR + NOT_NUMBER_ERROR);
		}
	}

	private static void isDividable(int balance) {
		if (balance % TEN_WON != ZERO_WON) {
			throw new IllegalArgumentException(ERROR + NOT_DIVIDABLE_ERROR);
		}
	}

	private static void isPositive(int balance) {
		if (balance < ZERO_WON) {
			throw new IllegalArgumentException(ERROR + NOT_POSITIVE_ERROR);
		}
	}

	public static List<String> isValidItems(String input) {
		List<String> items = isNotBlank(input);
		isNotEmpty(items);
		return items;
	}

	private static List<String> isNotBlank(String input) {
		if (input.equals(BLANK)) {
			throw new IllegalArgumentException(ERROR + NO_ITEMS_ERROR);
		}
		return Arrays.asList(input.split(ITEM_DIVIDER));
	}

	private static void isNotEmpty(List<String> items) {
		if (items.size() == EMPTY) {
			throw new IllegalArgumentException(ERROR + NO_ITEMS_ERROR);
		}
	}

	public static List<String> isValidItem(String input) {
		List<String> item = isInFormat(input);
		isValidPrice(item);
		isEnough(item);
		return item;
	}

	private static List<String> isInFormat(String input) {
		if (!Pattern.matches(REGEX, input)) {
			throw new IllegalArgumentException(ERROR + NOT_VALID_FORMAT);
		}
		return Arrays.asList(input.substring(ITEM_PACKAGE, input.length() - ITEM_PACKAGE).split(INFO_DIVIDER));
	}

	private static void isValidPrice(List<String> item) {
		if (Integer.parseInt(item.get(PRICE)) % TEN_WON != ZERO_WON) {
			throw new IllegalArgumentException(ERROR + NOT_VALID_PRICE);
		}
	}

	private static void isEnough(List<String> item) {
		if (Integer.parseInt(item.get(QUANTITY)) <= EMPTY) {
			throw new IllegalArgumentException(ERROR + NOT_VALID_QUANTITY);
		}
	}

	public static void isEnoughBalance(int balance, Items items) {
		if (balance < items.getExistingCheapest()) {
			throw new IllegalArgumentException(ERROR + NOTHING_TO_BUY);
		}
	}

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
