package vendingmachine.view;

import java.util.List;

import vendingmachine.constants.ErrorConstants;
import vendingmachine.constants.ValidateConstants;
import vendingmachine.domain.Product;

public class Validator {
	public int validateMoney(String inputString) {
		int number = checkNumber(inputString);
		checkOverZero(number);
		checkDivisionByTen(number);
		return number;
	}

	public Product validateProduct(String productString) {
		productString = removeDelimiters(productString);
		String [] splits = splitWithDelimiter(productString, ValidateConstants.PRODUCT_CONTENT_DELIMITER);
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
		String name = splits[ValidateConstants.NAME_INDEX];
		int price = validatePrice(splits[ValidateConstants.PRICE_INDEX]);
		int quantity = validateQuantity(splits[ValidateConstants.QUANTITY_INDEX]);
		return new Product(name, price, quantity);
	}

	private void checkProductContentSize(int length) {
		if(length < ValidateConstants.PRODUCT_CONTENT_SIZE) {
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
		if(price < ValidateConstants.MINIMUM_MONEY) {
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
		if(quantity < ValidateConstants.MINIMUM_QUANTITY) {
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
		if(number < ValidateConstants.MINIMUM_MONEY) {
			throw new IllegalArgumentException(ErrorConstants.ERROR_MONEY_RANGE);
		}
	}

	private void checkDivisionByTen(int number) {
		if(number % ValidateConstants.DIVISION_VALUE != 0) {
			throw new IllegalArgumentException(ErrorConstants.ERROR_MONEY_DIVISION);
		}
	}
}
