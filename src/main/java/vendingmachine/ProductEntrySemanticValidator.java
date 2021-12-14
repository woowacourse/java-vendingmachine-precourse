package vendingmachine;

import java.util.List;

public class ProductEntrySemanticValidator extends NumberValidator {
	private static final int MINIMUM_PRICE = 100;
	private static final int MINIMUM_NUMBER = 1;
	private static final int BRACKET_CHAR_LENGTH = 1;
	private static final String ENTRY_ELEMENT_SEPARATOR = ",";
	private static final int INDEX_OF_PRODUCT_PRICE = 1;
	private static final int INDEX_OF_PRODUCT_NUMBER = 2;

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
		isMultipleOfTen(priceInInt, Error.NOT_MULTIPLE_OF_TEN_PRODUCT_PRICE);
		isMoreThanThreshold(priceInInt, MINIMUM_PRICE, Error.NOT_MORE_THAN_A_HUNDRED_WON_PRODUCT_PRICE);
	}

	private void validateNumber(String number) {
		isNumber(number, Error.NOT_NUMBER_PRODUCT_NUMBER);
		int numberInInt = Integer.parseInt(number);
		isMoreThanThreshold(numberInInt, MINIMUM_NUMBER, Error.NOT_MORE_THAN_ONE_PRODUCT_NUMBER);
	}
}
