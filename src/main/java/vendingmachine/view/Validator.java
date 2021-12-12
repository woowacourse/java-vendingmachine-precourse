package vendingmachine.view;

import java.util.ArrayList;
import java.util.List;

import vendingmachine.constants.ErrorConstants;
import vendingmachine.constants.ValidateConstants;
import vendingmachine.domain.Product;

public class Validator {
	public int validateCommonMoney(String inputString) {
		int number = checkNumberFormat(inputString);
		checkDivisionByTen(number);
		return number;
	}

	public int validatePriceAndUserMoney(String inputString) {
		int number = validateCommonMoney(inputString);
		checkOverMinimumMoney(number);
		return number;
	}

	public List<Product> validateProductList(String inputString) {
		String [] splits = splitWithDelimiter(inputString, ValidateConstants.PRODUCT_DELIMITER);
		List<Product> products = new ArrayList<>();
		for(String productString : splits) {
			Product product = validateProduct(productString);
			validateProductRedundant(products, product.getName());
			products.add(product);
		}
		return products;
	}

	private Product validateProduct(String productString) {
		productString = removeDelimiters(productString);
		String [] splits = splitWithDelimiter(productString, ValidateConstants.PRODUCT_CONTENT_DELIMITER);
		return checkProductFormat(splits);
	}

	private String [] splitWithDelimiter(String input, String delimiter) {
		return input.split(delimiter);
	}

	private String removeDelimiters(String productString) {
		if(!productString.startsWith(ValidateConstants.PRODUCT_START_DELIMITER)
			|| !productString.endsWith(ValidateConstants.PRODUCT_END_DELIMITER)) {
			throw new IllegalArgumentException(ErrorConstants.ERROR_PRODUCT_FORMAT);
		}
		return productString.replace(ValidateConstants.PRODUCT_START_DELIMITER, "")
			.replace(ValidateConstants.PRODUCT_END_DELIMITER, "");
	}

	private Product checkProductFormat(String [] splits) {
		checkProductContentSize(splits.length);
		String name = splits[ValidateConstants.NAME_INDEX];
		int price = validatePriceAndUserMoney(splits[ValidateConstants.PRICE_INDEX]);
		int quantity = validateQuantity(splits[ValidateConstants.QUANTITY_INDEX]);
		return new Product(name, price, quantity);
	}

	private void checkProductContentSize(int length) {
		if(length < ValidateConstants.PRODUCT_CONTENT_SIZE) {
			throw new IllegalArgumentException(ErrorConstants.ERROR_PRODUCT_CONTENT_SIZE);
		}
	}

	private void validateProductRedundant(List<Product> productList, String name) {
		Product found =  productList.stream()
			.filter(product -> name.equals(product.getName()))
			.findAny()
			.orElse(null);
		if(found != null) {
			throw new IllegalArgumentException(ErrorConstants.ERROR_PRODUCT_NAME_REDUNDANT);
		}
	}

	private int validateQuantity(String quantity) {
		int number = checkNumberFormat(quantity);
		checkQuantityFormat(number);
		return number;
	}

	private void checkQuantityFormat(int quantity) {
		if(quantity < ValidateConstants.MINIMUM_QUANTITY) {
			throw new IllegalArgumentException(ErrorConstants.ERROR_PRODUCT_QUANTITY_RANGE);
		}
	}

	private void checkSize(String inputString) {
		if(inputString.length() == 0) {
			throw new IllegalArgumentException(ErrorConstants.ERROR_NUMBER);
		}
	}

	private int checkNumberFormat(String inputString) {
		checkSize(inputString);
		return checkNumber(inputString);
	}

	private int checkNumber(String inputString) {
		boolean number = inputString.chars().allMatch( Character::isDigit);
		if(!number) {
			throw new IllegalArgumentException(ErrorConstants.ERROR_NUMBER);
		}
		return Integer.parseInt(inputString);
	}

	private void checkOverMinimumMoney(int number) {
		if(number < ValidateConstants.MINIMUM_MONEY) {
			throw new IllegalArgumentException(ErrorConstants.ERROR_MONEY_RANGE);
		}
	}

	private void checkDivisionByTen(int number) {
		if(number == 0) {
			throw new IllegalArgumentException(ErrorConstants.ERROR_MONEY_ZERO);
		}

		if(number % ValidateConstants.DIVISION_VALUE != 0) {
			throw new IllegalArgumentException(ErrorConstants.ERROR_MONEY_DIVISION);
		}
	}
}
