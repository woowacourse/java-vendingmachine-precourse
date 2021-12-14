package vendingmachine.validation;

import java.util.Arrays;
import java.util.List;

import vendingmachine.domain.Product;
import vendingmachine.exception.ErrorMessage;
import vendingmachine.validation.enumclass.Constant;

public class GlobalValidation {
	private static final String OPEN_BRACKET = "[";
	private static final String CLOSE_BRACKET = "]";
	private static final String DIVISOR_PRODUCT_LIST = ";";

	public static void validateCostIsNaturalNumber(String willHoldMoney) {
		validateStringIsInt(willHoldMoney, ErrorMessage.COST_IS_NOT_NUMBER_ERROR);

		if (Integer.parseInt(willHoldMoney) <= Constant.ZERO.getNumber()) {
			throw new IllegalArgumentException(ErrorMessage.COST_IS_NOT_NUMBER_ERROR.getErrorMessage());
		}
	}

	public static void validateInputIsNull(String willHoldMoney) {
		validateStringIsBlank(willHoldMoney, ErrorMessage.INPUT_IS_BLANK_ERROR);
	}

	public static void validateCostIsDivideTen(String willHoldMoney) {
		validateNumberIsDivideTen(willHoldMoney, ErrorMessage.COST_IS_NOT_DIVIDE_TEN_ERROR);
	}

	public static void validateProductsInputFormat(String inputStr) {
		for (String product : inputStr.split(DIVISOR_PRODUCT_LIST)) {
			validateStringContainsSquareBracket(product, ErrorMessage.PRODUCT_INPUT_FORMAT_ERROR);
		}
	}

	private static void validateStringContainsSquareBracket(String string, ErrorMessage errorMessage) {
		if (!string.contains(OPEN_BRACKET) || !string.contains(CLOSE_BRACKET)) {
			throw new IllegalArgumentException(errorMessage.getErrorMessage());
		}
	}

	public static void validateProductLengthAndBlank(String[] product) {
		if (product.length != Constant.THREE.getNumber()) {
			throw new IllegalArgumentException(ErrorMessage.PRODUCT_INPUT_INFORMATION_ERROR.getErrorMessage());
		}

		Arrays.stream(product).forEach(p -> validateStringIsBlank(p, ErrorMessage.PRODUCT_INPUT_INFORMATION_ERROR));
	}

	public static void validateProductPrice(String price) {
		validateStringIsInt(price, ErrorMessage.PRODUCT_PRICE_IS_NOT_MORE_THAN_100_ERROR);

		if (Integer.parseInt(price) < Constant.HUNDRED.getNumber()) {
			throw new IllegalArgumentException(ErrorMessage.PRODUCT_PRICE_IS_NOT_MORE_THAN_100_ERROR.getErrorMessage());
		}

		validateNumberIsDivideTen(price, ErrorMessage.PRODUCT_PRICE_IS_NOT_DIVIDE_TEN_ERROR);
	}

	public static void validateProductAmount(String amount) {
		validateStringIsInt(amount, ErrorMessage.PRODUCT_AMOUNT_IS_NOT_NATURAL_NUMBER_ERROR);
		validateNumberIsZero(Integer.parseInt(amount), ErrorMessage.PRODUCT_AMOUNT_IS_NOT_NATURAL_NUMBER_ERROR);
	}

	public static void validateProductIsDistinct(Product product, List<Product> products) {
		if (products.contains(product)) {
			throw new IllegalArgumentException(ErrorMessage.PRODUCT_IS_DISTINCT_ERROR.getErrorMessage());
		}
	}

	public static void validateProductIsNotInProducts(String name, List<Product> products) {
		if (!products.contains(new Product(name, Constant.ZERO.getNumber(), Constant.ZERO.getNumber()))) {
			throw new IllegalArgumentException(ErrorMessage.PRODUCT_NAME_IS_NOT_IN_PRODUCTS.getErrorMessage());
		}
	}

	public static void validateProductAmountIsZero(int productAmount) {
		validateNumberIsZero(productAmount, ErrorMessage.PRODUCT_AMOUNT_IS_ZERO_ERROR);
	}

	private static void validateStringIsInt(String str, ErrorMessage errorMessage) {
		for (char c : str.toCharArray()) {
			validateCharIsInt(c, errorMessage);
		}
	}

	private static void validateCharIsInt(char c, ErrorMessage errorMessage) {
		if (!Character.isDigit(c)) {
			throw new IllegalArgumentException(errorMessage.getErrorMessage());
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
