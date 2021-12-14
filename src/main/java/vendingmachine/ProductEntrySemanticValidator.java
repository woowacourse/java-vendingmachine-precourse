package vendingmachine;

import java.util.List;

public class ProductEntrySemanticValidator {
	private static final int MINIMUM_PRICE = 100;
	private static final int PRICE_DIVISOR = 10;
	private static final int MINIMUM_NUMBER = 1;
	private static final int INDEX_OF_PRODUCT_NAME = 0;
	private static final int INDEX_OF_PRODUCT_PRICE = 1;
	private static final int INDEX_OF_PRODUCT_NUMBER = 2;
	private static final int BRACKET_CHAR_LENGTH = 1;
	private static final String ENTRY_ELEMENT_SEPARATOR = ",";

	public ProductEntrySemanticValidator() {
	}

	public boolean validate(List<String> entries) {
		try {
			entries.forEach(this::validateEntry);
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			return false;
		}
		return true;
	}

	private void validateEntry(String entry) {
		String entryWithoutBlank = entry.trim();
		String[] elements = entryWithoutBlank
			.substring(BRACKET_CHAR_LENGTH, entryWithoutBlank.length() - BRACKET_CHAR_LENGTH)
			.split(ENTRY_ELEMENT_SEPARATOR);
		validatePrice(elements[INDEX_OF_PRODUCT_PRICE].trim());
		validateNumber(elements[INDEX_OF_PRODUCT_NUMBER].trim());
	}

	private void validatePrice(String price) {
		isNumber(price, Error.NOT_NUMBER_PRODUCT_PRICE);
		int priceInInt = Integer.parseInt(price);
		isMultipleOfTen(priceInInt);
		isEqualOrGreater(priceInInt, MINIMUM_PRICE, Error.NOT_MORE_THAN_A_HUNDRED_WON_PRODUCT_PRICE);
	}

	private void validateNumber(String number) {
		isNumber(number, Error.NOT_NUMBER_PRODUCT_NUMBER);
		int numberInInt = Integer.parseInt(number);
		isEqualOrGreater(numberInInt, MINIMUM_NUMBER, Error.NOT_MORE_THAN_ONE_PRODUCT_NUMBER);
	}

	private void isNumber(String numberInString, Error error) throws IllegalArgumentException {
		System.out.println(numberInString);
		try {
			Integer.parseInt(numberInString);
		} catch (NumberFormatException exception) {
			throw new IllegalArgumentException(error.getMessage());
		}
	}

	private void isMultipleOfTen(int money) throws IllegalArgumentException {
		if (money % PRICE_DIVISOR > 0) {
			throw new IllegalArgumentException(Error.NOT_MULTIPLE_OF_TEN_PRODUCT_PRICE.getMessage());
		}
	}

	private void isEqualOrGreater(int number, int threshold, Error error) throws IllegalArgumentException {
		if (threshold > number) {
			throw new IllegalArgumentException(error.getMessage());
		}
	}
}
