package vendingmachine.utils;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import vendingmachine.domain.Product;
import vendingmachine.domain.Products;

public class Validator {

	public static void isHoldingAmount(String input) {
		isHoldingAmountNumber(input);

		int holdingAmount = Integer.parseInt(input);

		isHoldingAmountLessThanMax(holdingAmount);
		isHoldingAmountGreaterThanMin(holdingAmount);
		isHoldingAmountDivide(holdingAmount);
	}

	public static void isHoldingAmountNumber(String input) {
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ErrorMessage.COMMON + ErrorMessage.HOLDING_AMOUNT_NUM);
		}
	}

	public static void isHoldingAmountGreaterThanMin(int holdingAmount) {
		if (holdingAmount < Constant.HOLDING_AMOUNT_MIN) {
			throw new IllegalArgumentException(ErrorMessage.COMMON + ErrorMessage.HOLDING_AMOUNT_MIN);
		}
	}

	public static void isHoldingAmountLessThanMax(int holdingAmount) {
		if (holdingAmount > Constant.HOLDING_AMOUNT_MAX) {
			throw new IllegalArgumentException(ErrorMessage.COMMON + ErrorMessage.HOLDING_AMOUNT_MAX);
		}
	}

	public static void isHoldingAmountDivide(int holdingAmount) {
		if (holdingAmount % Constant.HOLDING_AMOUNT_DIVIDE != Constant.HOLDING_AMOUNT_REMAINDER) {
			throw new IllegalArgumentException(ErrorMessage.COMMON + ErrorMessage.HOLDING_AMOUNT_DIVIDE);
		}
	}

	public static void isProducts(String input) {
		existsLastProduct(input);

		String[] products = (input + Constant.PRODUCTS_SPLIT).split(Constant.PRODUCTS_SPLIT);
		isProductsSplit(products);

		List<String[]> product = Arrays.stream(products)
			.map(e -> e.substring(1, e.length() - 1))
			.map(e -> e.split(Constant.PRODUCT_SPLIT))
			.collect(Collectors.toList());
		isProductNum(product);
		isProductDuplicate(product);
		isProduct(product);
	}

	public static void existsLastProduct(String input) {
		if (input.endsWith(Constant.PRODUCTS_SPLIT)) {
			throw new IllegalArgumentException(ErrorMessage.COMMON + ErrorMessage.PRODUCTS_SPLIT);
		}
	}

	public static void isProductsSplit(String[] input) {
		long count = Arrays.stream(input)
			.filter(e -> e.startsWith(Constant.PRODUCT_START) && e.endsWith(Constant.PRODUCT_LAST))
			.count();
		if (count != input.length) {
			throw new IllegalArgumentException(ErrorMessage.COMMON + ErrorMessage.PRODUCT_SPLIT);
		}
	}

	public static void isProductNum(List<String[]> input) {
		if (input.stream()
			.filter(e -> e.length == Constant.PRODUCT_NUM)
			.count() != input.size()) {
			throw new IllegalArgumentException(ErrorMessage.COMMON + ErrorMessage.PRODUCT_INPUT);
		}
	}

	public static void isProductDuplicate(List<String[]> input) {
		Set<String> productName = input.stream()
			.map(e -> e[Constant.PRODUCT_NAME_INDEX])
			.collect(Collectors.toSet());
		if (productName.size() != input.size()) {
			throw new IllegalArgumentException(ErrorMessage.COMMON + ErrorMessage.PRODUCT_NAME_DUPLICATE);
		}
	}

	public static void isProduct(List<String[]> input) {
		isProductAmountNumber(input);
		isProductCountNumber(input);
	}

	public static void isProductAmountNumber(List<String[]> input) {
		try {
			input.stream()
				.map(e -> Integer.parseInt(e[Constant.PRODUCT_AMOUNT_INDEX]));
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ErrorMessage.COMMON + ErrorMessage.PRODUCT_AMOUNT_NUM);
		}
	}

	public static void isProductCountNumber(List<String[]> input) {
		try {
			input.stream()
				.map(e -> Integer.parseInt(e[Constant.PRODUCT_COUNT_INDEX]));
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ErrorMessage.COMMON + ErrorMessage.PRODUCT_COUNT_NUM);
		}
	}

	public static void isEnteredAmount(String input) {
		isEnteredAmountNumber(input);

		int enteredAmount = Integer.parseInt(input);
		isEnteredAmountGreaterThanMin(enteredAmount);
		isEnteredAmountLessThanMax(enteredAmount);
		isEnteredAmountDivide(enteredAmount);
	}

	public static void isEnteredAmountNumber(String input) {
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ErrorMessage.COMMON + ErrorMessage.ENTERED_AMOUNT_NUM);
		}
	}

	public static void isEnteredAmountGreaterThanMin(int enteredAmount) {
		if (enteredAmount < Constant.ENTERED_AMOUNT_MIN) {
			throw new IllegalArgumentException(ErrorMessage.COMMON + ErrorMessage.ENTERED_AMOUNT_MIN);
		}
	}

	public static void isEnteredAmountLessThanMax(int enteredAmount) {
		if (enteredAmount > Constant.ENTERED_AMOUNT_MAX) {
			throw new IllegalArgumentException(ErrorMessage.COMMON + ErrorMessage.ENTERED_AMOUNT_MAX);
		}
	}

	public static void isEnteredAmountDivide(int enteredAmount) {
		if (enteredAmount % Constant.ENTERED_AMOUNT_DIVIDE != Constant.ENTERED_AMOUNT_REMAINDER) {
			throw new IllegalArgumentException(ErrorMessage.COMMON + ErrorMessage.ENTERED_AMOUNT_DIVIDE);
		}
	}

	public static void isProductToBuy(Products products, String input, int enteredAmount) {
		Optional<Product> product = products.findByName(input);
		if (!product.isPresent()) {
			throw new IllegalArgumentException(ErrorMessage.COMMON + ErrorMessage.PRODUCT_TO_BUY_EMPTY_PRODUCT);
		}
		if (product.get().isEmpty()) {
			throw new IllegalArgumentException(ErrorMessage.COMMON + ErrorMessage.PRODUCT_TO_BUY_EMPTY_COUNT);
		}
		if (!product.get().isBuy(enteredAmount)) {
			throw new IllegalArgumentException(ErrorMessage.COMMON + ErrorMessage.PRODUCT_TO_BUY_LACK);
		}
	}

}
