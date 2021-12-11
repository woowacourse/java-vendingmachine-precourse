package vendingmachine.view;

import java.util.List;

import vendingmachine.constants.ErrorConstants;
import vendingmachine.domain.Product;

public class Validator {
	private static final int DIVISION_VALUE = 10;
	private static final int PRODUCT_CONTENT_SIZE = 3;
	private static String PRODUCT_CONTENT_DELIMITER = ",";
	private static final int NAME_INDEX = 0;
	private static final int PRICE_INDEX = 1;
	private static final int QUANTITY_INDEX = 2;

	public int validateMoney(String inputString) {
		int number = checkNumber(inputString);
		checkOverZero(number);
		checkDivisionByTen(number);
		return number;
	}

	public Product validateProduct(String productString) {
		productString = removeDelimiters(productString);
		String [] splits = splitWithDelimiter(productString, PRODUCT_CONTENT_DELIMITER);
		return checkProductFormat(splits);
	}

	public String [] splitWithDelimiter(String input, String delimiter) {
		return input.split(delimiter);
	}

	private String removeDelimiters(String productString) {
		if(!productString.startsWith("[") || !productString.endsWith("]")) {
			throw new IllegalArgumentException(ErrorConstants.ERROR_PRODUCT_FORMAT);
		}
		return productString.replace("[", "").replace("]", "");
	}

	private Product checkProductFormat(String [] splits) {
		checkProductContentSize(splits.length);
		String name = splits[NAME_INDEX];
		int price = validatePrice(splits[PRICE_INDEX]);
		int quantity = validateQuantity(splits[QUANTITY_INDEX]);
		return new Product(name, price, quantity);
	}

	private void checkProductContentSize(int length) {
		if(length < PRODUCT_CONTENT_SIZE) {
			throw new IllegalArgumentException(ErrorConstants.ERROR_PRODUCT_CONTENT_SIZE);
		}
	}

	public void validateProductExist(List<Product> productList, String name) {
		Product found =  productList.stream()
			.filter(product -> name.equals(product.getName()))
			.findAny()
			.orElse(null);
		if(found != null) {
			throw new IllegalArgumentException(ErrorConstants.ERROR_PRODUCT_NAME_REDUNDANT);
		}
	}

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
		if(number < DIVISION_VALUE) {
			throw new IllegalArgumentException(ErrorConstants.ERROR_MONEY_RANGE);
		}
	}

	private void checkDivisionByTen(int number) {
		if(number % DIVISION_VALUE != 0) {
			throw new IllegalArgumentException(ErrorConstants.ERROR_MONEY_DIVISION);
		}
	}
}
