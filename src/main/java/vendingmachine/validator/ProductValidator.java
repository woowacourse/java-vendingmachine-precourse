package vendingmachine.validator;

import static vendingmachine.Constants.*;

import java.util.List;

import vendingmachine.service.ProductService;

public class ProductValidator extends CommonValidator {
	public static boolean checkProduct(String inputLine) {
		try {
			exceptionStringEmptyOrSpace(inputLine);
			exceptionNotContainsBrackets(inputLine);
			exceptionInvalidElements(inputLine);
			return true;
		} catch (IllegalArgumentException exception) {
			return false;
		}
	}

	private static void exceptionNotContainsBrackets(String inputLine) {
		if (inputLine.charAt(BRACKET_INDEX) != CHAR_LEFT_BRACKET
				|| inputLine.charAt(inputLine.length() - 1) != CHAR_RIGHT_BRACKET) {
			throw new IllegalArgumentException();
		}
	}

	private static void exceptionInvalidElements(String inputLine) {
		List<String> elements = ProductService.splitProductElements(inputLine);
		exceptionInvalidElementsSize(elements);
		exceptionInvalidName(elements.get(PRODUCT_NAME_INDEX));
		exceptionInvalidPrice(elements.get(PRODUCT_PRICE_INDEX));
		exceptionInvalidCount(elements.get(PRODUCT_COUNT_INDEX));
	}

	private static void exceptionInvalidElementsSize(List<String> elements) {
		if (elements.size() != PRODUCT_ELEMENT_SIZE) {
			throw new IllegalArgumentException();
		}
	}

	private static void exceptionInvalidName(String inputLine) {
		if (!CommonValidator.checkString(inputLine)) {
			throw new IllegalArgumentException();
		}
	}

	private static void exceptionInvalidPrice(String inputLine) {
		if (!PriceValidator.checkPrice(inputLine)) {
			throw new IllegalArgumentException();
		}
	}

	private static void exceptionInvalidCount(String inputLine) {
		if (!PositiveValidator.checkPositiveNumber(inputLine)) {
			throw new IllegalArgumentException();
		}
	}
}
