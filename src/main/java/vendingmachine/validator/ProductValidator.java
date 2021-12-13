package vendingmachine.validator;

import static vendingmachine.Constants.*;

import java.util.List;

import vendingmachine.model.ProductModel;
import vendingmachine.service.ProductService;
import vendingmachine.view.ErrorView;

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

	public static boolean checkProductName(String inputLine) {
		try {
			exceptionStringEmptyOrSpace(inputLine);
			exceptionNameNotMatch(inputLine);
			exceptionHasZeroCount(inputLine);
			return true;
		} catch (IllegalArgumentException exception) {
			ErrorView.error(ERROR_PRODUCTS);
			return false;
		}
	}

	private static void exceptionNameNotMatch(String inputLine) {
		if (!ProductModel.hasProductName(inputLine)) {
			throw new IllegalArgumentException();
		}
	}

	private static void exceptionHasZeroCount(String inputLine) {
		if (!ProductModel.hasMoreThanOneCount(inputLine)) {
			throw new IllegalArgumentException();
		}
	}

	private static void exceptionStringEmptyOrSpace(String inputLine) {
		exceptionStringEmpty(inputLine);
		exceptionStringSpace(inputLine);
	}

	private static void exceptionNotContainsBrackets(String inputLine) {
		if (inputLine.charAt(0) != '[' || inputLine.charAt(inputLine.length() - 1) != ']') {
			throw new IllegalArgumentException();
		}
	}

	private static void exceptionInvalidElements(String inputLine) {
		List<String> elements = ProductService.splitByComma(inputLine);
		exceptionInvalidElementsSize(elements);
		exceptionInvalidName(elements.get(0));
		exceptionInvalidPrice(elements.get(1));
		exceptionInvalidCount(elements.get(2));
	}

	private static void exceptionInvalidElementsSize(List<String> elements) {
		if (elements.size() != 3) {
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
