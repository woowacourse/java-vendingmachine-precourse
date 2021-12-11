package vendingmachine.view;

import vendingmachine.constants.ErrorConstants;
import vendingmachine.constants.InputConstants;
import vendingmachine.domain.Product;

public class Validator {

	public int validateStorageMoney(String inputString) {
		int number = checkNumber(inputString);
		checkOverZero(number);
		checkDivisionByTen(number);
		return number;
	}

	public Product validateProduct(String productString) {
		productString = removeDelimiters(productString);
		String [] splits = splitWithDelimiter(productString, ",");
		return checkProductFormat(splits);
	}

	public String [] splitWithDelimiter(String input, String delimiter) {
		return input.split(delimiter);
	}

	private String removeDelimiters(String productString) {
		if(!productString.startsWith("[") || !productString.endsWith("]")) {
			throw new IllegalArgumentException(ErrorConstants.ERROR_PRODUCT_FORMAT);
		}
		return productString.replace("\\[", "").replace("]", "");
	}

	private Product checkProductFormat(String [] splits) {
		if(splits.length < 3) {
			throw new IllegalArgumentException(ErrorConstants.ERROR_PRODUCT_CONTENT_SIZE);
		}
		String name = splits[0];
		int price = validatePrice(splits[1]);
		int quantity = validateQuantity(splits[2]);
		return new Product(name, price, quantity);
	}

	// TODO : 상품명이 중복인가?

	private int validatePrice(String price) {
		int number = checkNumber(price);
		checkPriceFormat(number);
		return number;
	}

	private void checkPriceFormat(int price) {
		if(price < 100) {
			throw new IllegalArgumentException(ErrorConstants.ERROR_PRODUCT_PRICE_RANGE);
		}
		checkDivisionByTen(price);
	}

	private int validateQuantity(String quantity) {
		int number = checkNumber(quantity);
		checkQuantityFormat(number);
		return number;
	}

	private void checkQuantityFormat(int quantity) {
		if(quantity < 1) {
			throw new IllegalArgumentException(ErrorConstants.ERROR_PRODUCT_QUANTITY_RANGE);
		}
	}

	private int checkNumber(String inputString) {
		boolean number = inputString.chars().allMatch( Character::isDigit);
		if(!number) {
			throw new IllegalArgumentException(ErrorConstants.ERROR_MONEY_NUMBER);
		}
		return Integer.parseInt(inputString);
	}

	private void checkOverZero(int number) {
		if(number < 10) {
			throw new IllegalArgumentException(ErrorConstants.ERROR_STORAGE_NUMBER_RANGE);
		}
	}

	private void checkDivisionByTen(int number) {
		if(number % 10 != 0) {
			throw new IllegalArgumentException(ErrorConstants.ERROR_MONEY_DIVISION);
		}
	}
}
