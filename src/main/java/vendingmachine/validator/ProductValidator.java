package vendingmachine.validator;

import static vendingmachine.validator.MoneyValidator.*;
import static vendingmachine.validator.NameValidator.*;

public class ProductValidator {

	public static final String OPENING_BRACKET = "[";
	public static final String CLOSING_BRACKET = "]";
	public static final String PRODUCT_CRITERIA = ";";
	public static final String ARGUMENT_CRITERIA = ",";
	private static final int NUMBER_OF_ARGUMENTS = 3;

	public static boolean isValidProducts(String input) {
		String[] products = input.split(PRODUCT_CRITERIA, -1);

		checkProductExist(products.length);

		for (String product : products) {
			checkProductInputForm(product);
		}

		return true;
	}

	private static void checkProductExist(int numberOfProducts) {
		if (numberOfProducts == 0) {
			throw new IllegalArgumentException(
				"각 상품은 " + PRODUCT_CRITERIA + "로 구분 지어져야 하고, 상품은 1개 이상이어야 합니다.");
		}
	}

	private static void checkProductInputForm(String product) {
		checkBracketExistAndValid(product);
		checkProductArguments(product);
	}

	private static void checkBracketExistAndValid(String product) {
		if (!product.startsWith(OPENING_BRACKET) || !product.endsWith(CLOSING_BRACKET)) {
			throw new IllegalArgumentException(
				"각 상품은" + OPENING_BRACKET + CLOSING_BRACKET + "으로 감싸져야 합니다.");
		}
	}

	private static void checkProductArguments(String product) {
		String bracketRemovedInput = product.replace(OPENING_BRACKET, "")
			.replace(CLOSING_BRACKET, "");
		String[] productArguments = bracketRemovedInput.split(ARGUMENT_CRITERIA, -1);

		checkArgumentsLength(productArguments.length);

		String productName = productArguments[0];
		checkProductName(productName);

		String productPrice = productArguments[1];
		checkProductPrice(productPrice);

		String productQuantity = productArguments[2];
		checkProductQuantity(productQuantity);
	}

	private static void checkArgumentsLength(int argumentsLength) {
		if (argumentsLength != NUMBER_OF_ARGUMENTS) {
			throw new IllegalArgumentException(
				"상품 정보는 " + NUMBER_OF_ARGUMENTS + "개이어야 하고, " +
					"\"" + ARGUMENT_CRITERIA + "\"" + "로 구분 지어져야 합니다.");
		}
	}

	private static void checkProductQuantity(String productQuantity) {
		for (int i = 0; i < productQuantity.length(); i++) {
			if (!Character.isDigit(productQuantity.charAt(i))) {
				throw new IllegalArgumentException("상품 수량은 자연수만 허용됩니다.");
			}
		}

		if (Integer.parseInt(productQuantity) == 0) {
			throw new IllegalArgumentException("상품 수량은 1개 이상이어야 합니다.");
		}
	}

}
