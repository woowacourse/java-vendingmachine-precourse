package utils.validator.vendingmachineproducts.productinformation;

import java.util.regex.Pattern;

public class ProductPriceValidator {
	private static final int MINIMUM_PRICE_UNIT = 10;
	private static final int RIGHT_NUMBER = 0;
	private static final int MIN_PRODUCT_PRICE_INPUT_LENGTH = 1;
	private static final int MINIMUM_PRICE = 100;
	private static final String ZERO = "0";
	private static final String PRICE_PATTERN = "^[0-9]+$";
	private static final String INPUT_NOTHING_ERROR_MESSAGE = "[ERROR] 입력한 자판기 상품가격이 없다.";
	private static final String NOT_RIGHT_PRICE_ERROR_MESSAGE = "[ERROR] 입력한 자판기 상품가격이 올바른수(양수)가 아니다.";
	private static final String START_PRICE_ERROR_MESSAGE = "[ERROR] 입력한 자판기 상품가격이 0으로 시작한다.";
	private static final String UNDER_THAN_MINIMUM_PRICE_ERROR_MESSAGE = "[ERROR] 입력한 자판기 상품가격이 100원 미만이다.";
	private static final String NOT_RIGHT_PRICE_UNIT_ERROR_MESSAGE = "[ERROR] 입력한 자판기 상품가격이 10으로 나누어 떨어지지 않는다.";

	private ProductPriceValidator() {
	}

	public static boolean isValidProductPrice(String productPrice) {
		if (isValidInputLength(productPrice) && isRightNumber(productPrice) && !isUnderThanMinimumPrice(productPrice)
			&& isDivisibleByMinimumPriceUnit(productPrice)) {
			return true;
		}
		throw new IllegalArgumentException();
	}

	private static boolean isValidInputLength(String productPrice) {
		if (productPrice.length() < MIN_PRODUCT_PRICE_INPUT_LENGTH) {
			throw new IllegalArgumentException(INPUT_NOTHING_ERROR_MESSAGE);
		}
		return true;
	}

	private static boolean isRightNumber(String productPrice) {
		if (!Pattern.matches(PRICE_PATTERN, productPrice)) {
			throw new IllegalArgumentException(NOT_RIGHT_PRICE_ERROR_MESSAGE);
		}
		if (productPrice.startsWith(ZERO)) {
			throw new IllegalArgumentException(START_PRICE_ERROR_MESSAGE);
		}
		return true;
	}

	private static boolean isUnderThanMinimumPrice(String productPrice) {
		if (Integer.parseInt(productPrice) < MINIMUM_PRICE) {
			throw new IllegalArgumentException(UNDER_THAN_MINIMUM_PRICE_ERROR_MESSAGE);
		}
		return false;
	}

	private static boolean isDivisibleByMinimumPriceUnit(String productPrice) {
		if (Integer.parseInt(productPrice) % MINIMUM_PRICE_UNIT != RIGHT_NUMBER) {
			throw new IllegalArgumentException(NOT_RIGHT_PRICE_UNIT_ERROR_MESSAGE);
		}
		return true;
	}
}
