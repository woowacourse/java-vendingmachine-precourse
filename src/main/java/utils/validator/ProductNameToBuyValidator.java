package utils.validator;

public class ProductNameToBuyValidator {
	private static final int MIN_PRODUCT_NAME_INPUT_LENGTH = 1;
	private static final String BLANK = " ";
	private static final String INPUT_NOTHING_ERROR_MESSAGE = "[ERROR] 입력한 구매할 상품명이 없다.";
	private static final String HAS_BLANK_ERROR_MESSAGE = "[ERROR] 입력한 구매할 상품명에 공백이 있다.";

	private ProductNameToBuyValidator() {
	}

	public static String checkValidProductNameToBuy(String productNameToBuy) {
		if (isValidInputLength(productNameToBuy) && !hasBlankInInput(productNameToBuy)) {
			return productNameToBuy;
		}
		throw new IllegalArgumentException();
	}

	private static boolean isValidInputLength(String productNameToBuy) {
		if (productNameToBuy.length() < MIN_PRODUCT_NAME_INPUT_LENGTH) {
			throw new IllegalArgumentException(INPUT_NOTHING_ERROR_MESSAGE);
		}
		return true;
	}

	private static boolean hasBlankInInput(String productNameToBuy) {
		if (productNameToBuy.contains(BLANK)) {
			throw new IllegalArgumentException(HAS_BLANK_ERROR_MESSAGE);
		}
		return false;
	}
}
