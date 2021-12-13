package utils.validator.products;

import java.util.Arrays;
import java.util.List;

import utils.validator.products.productinformation.ProductCountValidator;
import utils.validator.products.productinformation.ProductNameValidator;
import utils.validator.products.productinformation.ProductPriceValidator;

public class ProductValidator {
	private static final int START_INDEX = 1;
	private static final int RIGHT_PRODUCT_INFORMATION_COUNT = 3;
	private static final int PRODUCT_NAME_INDEX = 0;
	private static final int PRODUCT_PRICE_INDEX = 1;
	private static final int PRODUCT_COUNT_INDEX = 2;
	private static final String LEFT_BRACKET = "[";
	private static final String RIGHT_BRACKET = "]";
	private static final String COMMA = ",";
	private static final String NOT_RIGHT_START_OR_FINISH_ERROR_MESSAGE = "[ERROR] 입력한 자판기 상품 중 '['로 시작하지 않거나 ']'로 끝나지 않는 입력이 있다.";
	private static final String FINISH_COMMA_ERROR_MESSAGE = "[ERROR] 입력한 자판기 상품 중 문자열이 ',' 끝나는 경우가 있다.";
	private static final String NOT_RIGHT_INFORMATION_COUNT_ERROR_MESSAGE = "[ERROR] 입력한 자판기 상품 중 상품 정보가 3개가 아닌 경우가 있다.";

	private ProductValidator() {
	}

	public static String checkValidProduct(String product) {
		if (isRightStartAndRightFinish(product) && !isFinishAsComma(product) && hasThreeInformation(product)) {
			return checkValidProductInformation(product);
		}
		throw new IllegalArgumentException();
	}

	private static boolean isRightStartAndRightFinish(String product) {
		if (product.startsWith(LEFT_BRACKET) && product.endsWith(RIGHT_BRACKET)) {
			return true;
		}
		throw new IllegalArgumentException(NOT_RIGHT_START_OR_FINISH_ERROR_MESSAGE);
	}

	private static boolean isFinishAsComma(String product) {
		int lastIndex = product.length() - 1;
		if (product.substring(START_INDEX, lastIndex).endsWith(COMMA)) {
			throw new IllegalArgumentException(FINISH_COMMA_ERROR_MESSAGE);
		}
		return false;
	}

	private static boolean hasThreeInformation(String product) {
		if (product.split(COMMA).length != RIGHT_PRODUCT_INFORMATION_COUNT) {
			throw new IllegalArgumentException(NOT_RIGHT_INFORMATION_COUNT_ERROR_MESSAGE);
		}
		return true;
	}

	private static String checkValidProductInformation(String product) {
		int lastIndex = product.length() - 1;
		List<String> productInformation = Arrays.asList(product.substring(START_INDEX, lastIndex).split(COMMA));
		if (isValidProductName(productInformation.get(PRODUCT_NAME_INDEX)) && isValidProductPrice(
			productInformation.get(PRODUCT_PRICE_INDEX)) && isValidProductCount(
			productInformation.get(PRODUCT_COUNT_INDEX))) {
			return String.join(COMMA, productInformation);
		}
		throw new IllegalArgumentException();
	}

	private static boolean isValidProductName(String productName) {
		if (!ProductNameValidator.isValidProductName(productName)) {
			throw new IllegalArgumentException();
		}
		return true;
	}

	private static boolean isValidProductPrice(String productPrice) {
		if (!ProductPriceValidator.isValidProductPrice(productPrice)) {
			throw new IllegalArgumentException();
		}
		return true;
	}

	private static boolean isValidProductCount(String productCount) {
		if (!ProductCountValidator.isValidProductCount(productCount)) {
			throw new IllegalArgumentException();
		}
		return true;
	}
}
