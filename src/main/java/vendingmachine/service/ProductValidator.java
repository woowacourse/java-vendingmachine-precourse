package vendingmachine.service;

import vendingmachine.constants.ProductConstant;

public class ProductValidator {

	public void isValid(String[] product) {
		isValidName(product[ProductConstant.NAME_INDEX]);
		isValidPrice(product[ProductConstant.PRICE_INDEX]);
		isValidStock(product[ProductConstant.STOCK_INDEX]);

	}

	public boolean isValidName(String name) {
		if (!name.matches(ProductConstant.NAME_REGEX)) {
			throw new IllegalArgumentException(ProductConstant.NAME_ERROR_MESSAGE);
		}
		return true;

	}

	public boolean isValidPrice(String price) {
		if (!isNumeric(price)) {
			throw new IllegalArgumentException(ProductConstant.PRICE_NON_NUMERIC_ERROR_MESSAGE);
		}
		if (Integer.parseInt(price) % 10 != 0) {
			throw new IllegalArgumentException(ProductConstant.DIVIDE_TEN_ERROR_MESSAGE);
		}
		if (Integer.parseInt(price) < ProductConstant.MINIMUM_PRICE) {
			throw new IllegalArgumentException(ProductConstant.MINIMUM_PRICE_ERROR_MESSAGE);
		}
		return true;
	}

	public boolean isNumeric(String string) {
		return string.matches(ProductConstant.NUMERIC_REGEX);
	}

	public boolean isValidStock(String stock) {
		if (isNumeric(stock)) {
			return true;
		}
		throw new IllegalArgumentException(ProductConstant.STOCK_NON_NUMERIC_ERROR_MESSAGE);
	}
}