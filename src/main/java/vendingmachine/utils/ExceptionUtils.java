package vendingmachine.utils;

import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import vendingmachine.model.Product;
import vendingmachine.model.VendingMachine;

public class ExceptionUtils {

	private ExceptionUtils() {
	}

	private static final int MINIMUM_NATURAL_NUMBER = 1;
	private static final int MINIMUM_UNIT_OF_MONEY = 10;
	private static final int APPROPRIATE_REMAINDER = 0;
	private static final int MAXIMUM_INT_VALUE = 2147483647;
	private static final int MINIMUM_PRICE = 100;
	private static final String SPACE = " ";
	private static final String REGULAR_EXPRESSION_ONLY_NUMBER = "^\\d*$";
	private static final String ERROR_HEADER = "[ERROR] ";
	private static final String SPACE_ERROR_MESSAGE = "공백이 입력되었습니다.";
	private static final String NATURAL_NUMBER_ERROR_MESSAGE = "자연수만 입력 가능합니다.";
	private static final String UNIT_ERROR_MESSAGE = "최소 단위 금액은 10원입니다. 10의 배수로 입력해주세요.";
	private static final String OVER_RANGE_ERROR_MESSAGE = "최대 허용하는 정수값을 초과했습니다.";
	private static final String REGULAR_EXPRESSION_PRODUCT_INFO = "^(\\[[0-9a-zA-Z가-힣]+,\\d+,\\d+])(;\\[[0-9a-zA-Z가-힣]+,\\d+,\\d+])*$";
	private static final String INVALID_PRODUCT_EXPRESSION_ERROR_MESSAGE = "알맞은 형태로 입력해주세요.";
	private static final String INVALID_PRICE_ERROR_MESSAGE = "상품의 가격은 100원 이상부터 입니다.";
	private static final String NOT_IN_VENDING_MACHINE = "해당 상품은 자판기에 없는 상품입니다.";
	private static final String INVALID_EXPENSIVE_PRODUCT = "남은 금액 보다 비싼 상품입니다.";

	public static void validateInputMoney(String inputMoney) {
		if (!validateSpace(inputMoney)) {
			throw new IllegalArgumentException(ERROR_HEADER + SPACE_ERROR_MESSAGE);
		}
		if (!validateNumber(inputMoney)) {
			throw new IllegalArgumentException(ERROR_HEADER + NATURAL_NUMBER_ERROR_MESSAGE);
		}
		if (!validateMaxValue(inputMoney)) {
			throw new IllegalArgumentException(ERROR_HEADER + OVER_RANGE_ERROR_MESSAGE);
		}
	}

	public static void validateMoney(int money) {
		if (!validatePositiveNumber(money)) {
			throw new IllegalArgumentException(ERROR_HEADER + NATURAL_NUMBER_ERROR_MESSAGE);
		}
		if (!validateMultiplicationOfTen(money)) {
			throw new IllegalArgumentException(ERROR_HEADER + UNIT_ERROR_MESSAGE);
		}
	}

	public static String validateInputProductsInfo(String inputProductsInfo) {
		if (!Pattern.matches(REGULAR_EXPRESSION_PRODUCT_INFO, inputProductsInfo)) {
			throw new IllegalArgumentException(
				ERROR_HEADER + INVALID_PRODUCT_EXPRESSION_ERROR_MESSAGE);
		}
		return inputProductsInfo;
	}

	public static void validateNameOfProduct(String name, VendingMachine vendingMachine) {
		List<Product> products = vendingMachine.getProducts();
		if (!validateSpace(name)) {
			throw new IllegalArgumentException(ERROR_HEADER + SPACE_ERROR_MESSAGE);
		}
		if (!validateProductInVendingMachine(name, products)) {
			throw new IllegalArgumentException((ERROR_HEADER + NOT_IN_VENDING_MACHINE));
		}
		for (Product product : products) {
			validateExpensiveProduct(name, product, vendingMachine.getRemainInsertMoney());
		}
	}

	public static int validatePriceOfProductsInfo(int price) {
		validateMoney(price);
		if (!validateOver100(price)) {
			throw new IllegalArgumentException(ERROR_HEADER + INVALID_PRICE_ERROR_MESSAGE);
		}
		return price;
	}

	public static int validateNumberOfProductsInfo(int number) {
		if (!validatePositiveNumber(number)) {
			throw new IllegalArgumentException(ERROR_HEADER + NATURAL_NUMBER_ERROR_MESSAGE);
		}
		return number;
	}

	private static boolean validateSpace(String inputMoney) {
		return (!(inputMoney.contains(SPACE) || inputMoney.isEmpty()));
	}

	private static boolean validateNumber(String inputMoney) {
		return inputMoney.matches(REGULAR_EXPRESSION_ONLY_NUMBER);
	}

	private static boolean validatePositiveNumber(int inputMoney) {
		return inputMoney >= MINIMUM_NATURAL_NUMBER;
	}

	private static boolean validateMultiplicationOfTen(int inputMoney) {
		return inputMoney % MINIMUM_UNIT_OF_MONEY == APPROPRIATE_REMAINDER;
	}

	private static boolean validateMaxValue(String inputMoney) {
		return Long.parseLong(inputMoney) <= MAXIMUM_INT_VALUE;
	}

	private static boolean validateOver100(int money) {
		return money >= MINIMUM_PRICE;
	}

	private static boolean validateProductInVendingMachine(String inputProduct,
		List<Product> products) {
		return products.stream().map(Product::getName).collect(Collectors.toList())
			.contains(inputProduct);
	}

	private static void validateExpensiveProduct(String inputProduct, Product product,  int remainInsertMoney) {
		if (Objects.equals(product.getName(), inputProduct)) {
			if (product.getPrice() > remainInsertMoney) {
				throw new IllegalArgumentException(ERROR_HEADER + INVALID_EXPENSIVE_PRODUCT);
			}
		}
	}
}
