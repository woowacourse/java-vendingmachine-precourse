package utils.validator.vendingmachineproducts;

import java.util.Arrays;
import java.util.List;

import utils.validator.vendingmachineproducts.productinformation.ProductCountValidator;
import utils.validator.vendingmachineproducts.productinformation.ProductNameValidator;
import utils.validator.vendingmachineproducts.productinformation.ProductPriceValidator;

public class VendingMachineProductValidator {
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

	private VendingMachineProductValidator() {
	}

	public static String checkValidVendingMachineProduct(String vendingMachineProduct) {
		if (isRightStartAndRightFinish(vendingMachineProduct) && !isFinishAsComma(vendingMachineProduct)
			&& hasThreeInformation(vendingMachineProduct)) {
			checkValidProductInformation(vendingMachineProduct);
			return vendingMachineProduct;
		}
		throw new IllegalArgumentException();
	}

	private static boolean isRightStartAndRightFinish(String vendingMachineProduct) {
		if (vendingMachineProduct.startsWith(LEFT_BRACKET) && vendingMachineProduct.endsWith(RIGHT_BRACKET)) {
			return true;
		}
		throw new IllegalArgumentException(NOT_RIGHT_START_OR_FINISH_ERROR_MESSAGE);
	}

	private static boolean isFinishAsComma(String vendingMachineProduct) {
		int lastIndex = vendingMachineProduct.length() - 1;
		if (vendingMachineProduct.substring(START_INDEX, lastIndex).endsWith(COMMA)) {
			throw new IllegalArgumentException(FINISH_COMMA_ERROR_MESSAGE);
		}
		return false;
	}

	private static boolean hasThreeInformation(String vendingMachineProduct) {
		if (vendingMachineProduct.split(COMMA).length != RIGHT_PRODUCT_INFORMATION_COUNT) {
			throw new IllegalArgumentException(NOT_RIGHT_INFORMATION_COUNT_ERROR_MESSAGE);
		}
		return true;
	}

	private static void checkValidProductInformation(String vendingMachineProduct) {
		int lastIndex = vendingMachineProduct.length() - 1;
		List<String> vendingMachineProductsInformation = Arrays.asList(
			vendingMachineProduct.substring(START_INDEX, lastIndex).split(COMMA));
		ProductNameValidator.isValidProductName(vendingMachineProductsInformation.get(PRODUCT_NAME_INDEX));
		ProductPriceValidator.isValidProductPrice(vendingMachineProductsInformation.get(PRODUCT_PRICE_INDEX));
		ProductCountValidator.isValidProductCount(vendingMachineProductsInformation.get(PRODUCT_COUNT_INDEX));
	}
}
