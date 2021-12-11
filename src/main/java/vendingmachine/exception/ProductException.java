package vendingmachine.exception;

import static vendingmachine.constant.Constant.*;
import static vendingmachine.constant.ErrorMessage.*;

public class ProductException {



	public static void checkProductException(String products) {
		checkProducts(products.split(SEME_COLON));
	}

	private static void checkProducts(String[] productSplitBySemeColon) {
		for (String product : productSplitBySemeColon) {
			checkParenthesisFormat(product);
			String[] productSplitFormat = product.replace(LEFT_PARENTHESIS, BLANK)
				.replace(RIGHT_PARENTHESIS, BLANK)
				.split(COMMA);
			checkSemeColonFormat(productSplitFormat);
			checkCommaFormat(productSplitFormat);
			checkProduct(productSplitFormat);
		}
	}

	private static void checkCommaFormat(String[] product) {
		if (product.length != LENGTH_OF_ARRAY_SPLIT_BY_COMMA) {
			throw new IllegalArgumentException(PRODUCT_COMMA_FORMAT_MSG);
		}
	}

	private static void checkSemeColonFormat(String[] product) {
		if (product.length > LENGTH_OF_ARRAY_SPLIT_BY_COMMA) {
			throw new IllegalArgumentException(PRODUCT_SEME_COLON_FORMAT_MSG);
		}
	}

	private static void checkParenthesisFormat(String array) {
		if (array.charAt(0) != '[' || ']' != array.charAt(array.length() - 1)) {
			throw new IllegalArgumentException(PRODUCT_PARENTHESIS_FORMAT_MSG);
		}
	}

	private static void checkProduct(String[] product) {
		checkProductName(product[0]);
		checkProductPrice(product[1]);
		checkProductQuantity(product[2]);
	}

	private static void checkProductName(String productName) {
		if (productName == null || productName.trim().isEmpty()) {
			throw new IllegalArgumentException(PRODUCT_NAME_EMPTY_MSG);
		}
	}

	private static void checkProductPrice(String productPrice) {
		checkEmptyPrice(productPrice);
		checkPriceIsInteger(productPrice);
		int price = Integer.parseInt(productPrice);
		checkPriceRange(price);
		checkPriceUnit(price);
	}

	private static void checkEmptyPrice(String price) {
		if (price == null || price.trim().isEmpty()) {
			throw new IllegalArgumentException(PRODUCT_PRICE_EMPTY_MSG);
		}
	}

	private static void checkPriceIsInteger(String price) {
		if (!price.chars().allMatch(Character::isDigit)) {
			throw new IllegalArgumentException(PRODUCT_PRICE_NOT_INTEGER_MSG);
		}
	}

	private static void checkPriceRange(int price) {
		if (price < MINIMUM_PRODUCT_PRICE) {
			throw new IllegalArgumentException(PRODUCT_PRICE_RANGE_ERROR_MSG);
		}
	}

	private static void checkPriceUnit(int price) {
		if (price % MINIMUM_COIN_AMOUNT != 0) {
			throw new IllegalArgumentException(PRODUCT_PRICE_UNIT_ERROR_MSG);
		}
	}

	private static void checkProductQuantity(String productQuantity) {
		checkEmptyQuantity(productQuantity);
		checkQuantityIsInteger(productQuantity);
		checkNegativeQuantity(productQuantity);
	}

	private static void checkEmptyQuantity(String quantity) {
		if (quantity == null || quantity.trim().isEmpty()) {
			throw new IllegalArgumentException(PRODUCT_QUANTITY_EMPTY_MSG);
		}
	}

	private static void checkQuantityIsInteger(String quantity) {
		if (!quantity.chars().allMatch(Character::isDigit)) {
			throw new IllegalArgumentException(PRODUCT_QUANTITY_NOT_INTEGER_MSG);
		}
	}

	private static void checkNegativeQuantity(String quantity) {
		if (Integer.parseInt(quantity) < DISCRIMINATION_NEGATIVE_NUMBER) {
			throw new IllegalArgumentException(PRODUCT_QUANTITY_NEGATIVE_MSG);
		}
	}
}
