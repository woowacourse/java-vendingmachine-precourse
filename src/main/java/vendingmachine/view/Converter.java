package vendingmachine.view;

import java.util.ArrayList;
import java.util.List;

import vendingmachine.constants.InputConstants;
import vendingmachine.domain.Product;

public class Converter {
	private static final int DIVISION_VALUE = 10;
	private static final int NAME_INDEX = 0;
	private static final int PRICE_INDEX = 1;
	private static final int QUANTITY_INDEX = 2;

	public int convertToInt(String inputString) {
		return Integer.valueOf(inputString);
	}

	public List<Product> convertToProductList(String inputString) {
		String [] splits = splitWithDelimiter(inputString, InputConstants.PRODUCT_DELIMITER);
		List<Product> products = new ArrayList<>();
		for(String productString : splits) {
			products.add(makeProduct(productString));
		}
		return products;
	}

	private Product makeProduct(String productString) throws IllegalArgumentException {
		String [] splits = splitWithDelimiter(productString, InputConstants.PRODUCT_CONTENT_DELIMITER);
		if(splits.length != InputConstants.PRODUCT_CONTENT_SIZE) {
			throw new IllegalArgumentException();
		}

		for(int i = 0; i < InputConstants.PRODUCT_CONTENT_SIZE; i++) {
			splits[i] = removeDelimiters(splits[i], i);
		}
		return new Product(splits[NAME_INDEX], convertToInt(splits[PRICE_INDEX]), convertToInt(splits[QUANTITY_INDEX]));
	}

	private String removeDelimiters(String inputString, int index) throws IllegalArgumentException {
		inputString = inputString.replaceAll("\\[", "").replaceAll("\\]","");
		if(index != 0) {
			checkNumberString(inputString);
		}
		return inputString;
	}

	private String [] splitWithDelimiter(String input, String delimiter) {
		return input.split(delimiter);
	}


	public void checkNumberString(String inputString) throws IllegalArgumentException {
		if(!checkSize(inputString) || !checkNumber(inputString)) {
			throw new IllegalArgumentException();
		}
	}

	private boolean checkSize(String inputString) {
		return inputString.length() > 0;
	}

	private boolean checkNumber(String inputString) {
		return inputString.chars().allMatch( Character::isDigit);
	}

	public void checkDivisionByTen(int number) throws IllegalArgumentException{
		if(number % DIVISION_VALUE != 0) {
			throw new IllegalArgumentException();
		}
	}
}
