package vendingmachine.validation;

import java.util.Arrays;
import java.util.List;

import vendingmachine.domain.Product;
import vendingmachine.exception.ErrorMessage;
import vendingmachine.validation.enumclass.Constant;

public class GlobalValidation {

	// 금액이 자연수인지 확인
	public static void validateCostIsNaturalNumber(String willHoldMoney) {
		validateCharIsInt(willHoldMoney, ErrorMessage.COST_IS_NOT_NUMBER_ERROR);

		if (Integer.parseInt(willHoldMoney) <= Constant.ZERO.getNumber()) {
			throw new IllegalArgumentException(ErrorMessage.COST_IS_NOT_NUMBER_ERROR.getErrorMessage());
		}
	}

	// 입력 값이 빈 값인지 확인
	public static void validateInputIsNull(String willHoldMoney) {
		validateStringIsBlank(willHoldMoney, ErrorMessage.INPUT_IS_BLANK_ERROR);
	}

	// 금액이 10으로 나누어 떨어지지 않는 경우
	public static void validateCostIsDivideTen(String willHoldMoney) {
		validateNumberIsDivideTen(willHoldMoney, ErrorMessage.COST_IS_NOT_DIVIDE_TEN_ERROR);
	}

	// 상품이 형식에 맞게 들어오지 않는 경우
	public static void validateProductsInputFormat(String inputStr) {
		for (String product : inputStr.split(";")) {
			if (!product.contains("[") || !product.contains("]")) {
				throw new IllegalArgumentException(ErrorMessage.PRODUCT_INPUT_FORMAT_ERROR.getErrorMessage());
			}
		}
	}

	// 상품의 길이가 3(상품명, 가격, 수량)이 아니고 빈 값일 있을 경우
	public static void validateProductLengthAndBlank(String[] product) {
		if (product.length != Constant.THREE.getNumber()) {
			throw new IllegalArgumentException(ErrorMessage.PRODUCT_INPUT_INFORMATION_ERROR.getErrorMessage());
		}

		Arrays.stream(product).forEach(p -> validateStringIsBlank(p, ErrorMessage.PRODUCT_INPUT_INFORMATION_ERROR));
	}

	// 상품 가격이 100 이상, 10으로 나누어 떨어지는 자연수가 아닐 경우
	public static void validateProductPrice(String price) {
		validateCharIsInt(price, ErrorMessage.PRODUCT_PRICE_IS_NOT_MORE_THAN_100_ERROR);

		if (Integer.parseInt(price) < Constant.HUNDRED.getNumber()) {
			throw new IllegalArgumentException(ErrorMessage.PRODUCT_PRICE_IS_NOT_MORE_THAN_100_ERROR.getErrorMessage());
		}

		validateNumberIsDivideTen(price, ErrorMessage.PRODUCT_PRICE_IS_NOT_DIVIDE_TEN_ERROR);
	}

	// 상품 수량이 자연수가 아닐 경우
	public static void validateProductAmount(String amount) {
		validateCharIsInt(amount, ErrorMessage.PRODUCT_AMOUNT_IS_NOT_NATURAL_NUMBER_ERROR);
		validateNumberIsZero(Integer.parseInt(amount), ErrorMessage.PRODUCT_AMOUNT_IS_NOT_NATURAL_NUMBER_ERROR);
	}

	// 상품이 중복되어 들어오는 경우
	public static void validateProductIsDistinct(Product product, List<Product> products) {
		if (products.contains(product)) {
			throw new IllegalArgumentException(ErrorMessage.PRODUCT_IS_DISTINCT_ERROR.getErrorMessage());
		}
	}

	// 구매할 상품명이 목록에 없을 경우
	public static void validateProductIsNotInProducts(String name, List<Product> products) {
		if (!products.contains(new Product(name, 0, 0))) {
			throw new IllegalArgumentException(ErrorMessage.PRODUCT_NAME_IS_NOT_IN_PRODUCTS.getErrorMessage());
		}
	}

	// 구매할 상품의 수량이 0인 경우
	public static void validateProductAmountIsZero(int productAmount) {
		validateNumberIsZero(productAmount, ErrorMessage.PRODUCT_AMOUNT_IS_ZERO_ERROR);
	}

	private static void validateCharIsInt(String str, ErrorMessage errorMessage) {
		for (char c : str.toCharArray()) {
			if (!Character.isDigit(c)) {
				throw new IllegalArgumentException(errorMessage.getErrorMessage());
			}
		}
	}

	private static void validateStringIsBlank(String inputStr, ErrorMessage errorMessage) {
		if (inputStr.replaceAll(" ", "").length() == Constant.ZERO.getNumber()) {
			throw new IllegalArgumentException(errorMessage.getErrorMessage());
		}
	}

	private static void validateNumberIsDivideTen(String number, ErrorMessage errorMessage) {
		if (Integer.parseInt(number) % Constant.TEN.getNumber() != Constant.ZERO.getNumber()) {
			throw new IllegalArgumentException(errorMessage.getErrorMessage());
		}
	}

	private static void validateNumberIsZero(int number, ErrorMessage errorMessage) {
		if (number == Constant.ZERO.getNumber()) {
			throw new IllegalArgumentException(errorMessage.getErrorMessage());
		}
	}
}
