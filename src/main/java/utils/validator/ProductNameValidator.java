package utils.validator;

public class ProductNameValidator {
	private static final int MIN_PRODUCT_NAME_INPUT_LENGTH = 1;
	private static final String BLANK = " ";
	private static final String INPUT_NOTHING_ERROR_MESSAGE = "[ERROR] 입력한 구매할 상품명이 없다.";
	private static final String HAS_BLANK_ERROR_MESSAGE = "[ERROR] 입력한 구매할 상품명에 공백이 있다.";

	private ProductNameValidator() {
	}

	public static String checkValidProductName(String productName) {
		if (isValidInputLength(productName) && !hasBlankInInput(productName)) {
			return productName;
		}
		throw new IllegalArgumentException();
	}

	private static boolean isValidInputLength(String productName) {
		if (productName.length() < MIN_PRODUCT_NAME_INPUT_LENGTH) {
			throw new IllegalArgumentException(INPUT_NOTHING_ERROR_MESSAGE);
		}
		return true;
	}

	private static boolean hasBlankInInput(String productName) {
		if (productName.contains(BLANK)) {
			throw new IllegalArgumentException(HAS_BLANK_ERROR_MESSAGE);
		}
		return false;
	}
}
