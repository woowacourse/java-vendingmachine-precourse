package utils.validator.vendingmachineproducts.productinformation;

public class ProductNameValidator {
	private static final int MIN_PRODUCT_NAME_INPUT_LENGTH = 1;
	private static final String INPUT_NOTHING_ERROR_MESSAGE = "[ERROR] 입력한 자판기 상품명이 없다.";

	private ProductNameValidator() {
	}

	public static boolean isValidProductName(String productName) {
		if (isValidInputLength(productName)) {
			return true;
		}
		throw new IllegalArgumentException();
	}

	private static boolean isValidInputLength(String productName) {
		if (productName.length() < MIN_PRODUCT_NAME_INPUT_LENGTH) {
			throw new IllegalArgumentException(INPUT_NOTHING_ERROR_MESSAGE);
		}
		return true;
	}
}
