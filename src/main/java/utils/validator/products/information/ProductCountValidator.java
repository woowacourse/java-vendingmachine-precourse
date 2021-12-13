package utils.validator.products.information;

import java.util.regex.Pattern;

public class ProductCountValidator {
	private static final int MIN_PRODUCT_COUNT_INPUT_LENGTH = 1;
	private static final String ZERO = "0";
	private static final String COUNT_PATTERN = "^[0-9]*$";
	private static final String INPUT_NOTHING_ERROR_MESSAGE = "[ERROR] 입력한 자판기 상품개수가 없다.";
	private static final String NOT_RIGHT_COUNT_ERROR_MESSAGE = "[ERROR] 입력한 자판기 상품개수가 올바른수(양수)가 아니다.";
	private static final String START_COUNT_ERROR_MESSAGE = "[ERROR] 입력한 자판기 상품개수가 0으로 시작한다.";

	private ProductCountValidator() {
	}

	public static boolean isValidProductCount(String productCount) {
		if (isValidInputLength(productCount) && isRightNumber(productCount)) {
			return true;
		}
		throw new IllegalArgumentException();
	}

	private static boolean isValidInputLength(String productCount) {
		if (productCount.length() < MIN_PRODUCT_COUNT_INPUT_LENGTH) {
			throw new IllegalArgumentException(INPUT_NOTHING_ERROR_MESSAGE);
		}
		return true;
	}

	private static boolean isRightNumber(String productCount) {
		if (!Pattern.matches(COUNT_PATTERN, productCount)) {
			throw new IllegalArgumentException(NOT_RIGHT_COUNT_ERROR_MESSAGE);
		}
		if (productCount.startsWith(ZERO)) {
			throw new IllegalArgumentException(START_COUNT_ERROR_MESSAGE);
		}
		return true;
	}
}
