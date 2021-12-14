package vendingmachine.utils;

import java.util.regex.Pattern;

public class ItemsValidation {
	private static final Pattern ITEMS_PATTERN = Pattern.compile(
		"\\[[가-힣|a-z|A-Z|0-9]+,[1-9][0-9]*,[1-9][0-9]*\\]+(;\\[[가-힣|a-z|A-Z|0-9]+,[1-9][0-9]*,[1-9][0-9]*\\])*");
	private static final int MIN_ITEM_PRICE = 100;
	private static final int MIN_COIN_PRICE = 10;

	public static void validateItemsInput(String itemsInput) {
		if (!ITEMS_PATTERN.matcher(itemsInput).matches()) {
			throw new IllegalArgumentException(
				"올바르지 않은 입력 형식입니다. '[상품명(한글, 알파벳, 숫자),상품 가격(숫자),상품 수량(숫자)];[상품명,상품 가격,상품 수량]...'");
		}
	}

	public static void validateItemAmount(String amount) {
		validateIntegerType(amount);
	}

	public static void validateItemPrice(String price) {
		validateIntegerType(price);
		int itemPrice = Integer.parseInt(price);
		if (itemPrice < MIN_ITEM_PRICE || itemPrice % MIN_COIN_PRICE != 0) {
			throw new IllegalArgumentException("상품 금액이 100원보다 작거나 10원 단위가 아닙니다.");
		}
	}

	public static void validateIntegerType(String money) {
		try {
			Integer.parseInt(money);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("상품 금액 혹은 수량이 32비트 정수입력을 벗어났습니다.");
		}
	}
}
