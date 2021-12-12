package vendingmachine.utils.exception;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import vendingmachine.model.Product;
import vendingmachine.model.VendingMachine;

public class ProductException {

	private static final int INITIAL_VALUE = 0;
	private static final int MINIMUM_PRICE = 100;
	private static final String ERROR_HEADER = "[ERROR] ";
	private static final String SPACE_ERROR_MESSAGE = "공백이 입력되었습니다.";
	private static final String NATURAL_NUMBER_ERROR_MESSAGE = "자연수만 입력 가능합니다.";
	private static final String REGULAR_EXPRESSION_PRODUCT_INFO = "^(\\[[0-9a-zA-Z가-힣]+,\\d+,\\d+])(;\\[[0-9a-zA-Z가-힣]+,\\d+,\\d+])*$";
	private static final String INVALID_PRODUCT_EXPRESSION_ERROR_MESSAGE = "알맞은 형태로 입력해주세요.";
	private static final String INVALID_PRICE_ERROR_MESSAGE = "상품의 가격은 100원 이상부터 입니다.";
	private static final String NOT_IN_VENDING_MACHINE = "해당 상품은 자판기에 없는 상품입니다.";
	private static final String INVALID_EXPENSIVE_PRODUCT = "남은 금액 보다 비싼 상품입니다.";
	private static final String NAME_DUPLICATED_ERROR = "상품 이름이 중복되었습니다.";
	private static final String SOLD_OUT_ERROR = "해당 상품은 매진입니다.";

	private ProductException() {
	}

	public static void validateInputProductsInfo(String inputProductsInfo) {
		if (MoneyException.containSpace(inputProductsInfo)) {
			throw new IllegalArgumentException(ERROR_HEADER + SPACE_ERROR_MESSAGE);
		}
		if (!isRightExpression(inputProductsInfo)) {
			throw new IllegalArgumentException(
				ERROR_HEADER + INVALID_PRODUCT_EXPRESSION_ERROR_MESSAGE);
		}
	}

	public static void validateName(String name, VendingMachine vendingMachine) {
		List<Product> products = vendingMachine.getProducts();
		if (!containInVendingMachine(name, products)) {
			throw new IllegalArgumentException((ERROR_HEADER + NOT_IN_VENDING_MACHINE));
		}
		if (isExpensiveThanRemain(products, name, vendingMachine.getRemainInsertMoney())) {
			throw new IllegalArgumentException(ERROR_HEADER + INVALID_EXPENSIVE_PRODUCT);
		}
	}

	public static void validateFilteredInfo(String[] filteredInfo) {
		validatePrice(filteredInfo[1]);
		validateNumber(filteredInfo[2]);
	}

	public static void validateDuplicatedName(List<Product> products) {
		if (products.stream().map(Product::getName).distinct().count() != products.size()) {
			throw new IllegalArgumentException(ERROR_HEADER + NAME_DUPLICATED_ERROR);
		}
	}

	public static void validateSoldOut(String inputProduct, List<Product> products) {
		if (products.stream().filter(product -> product.getName().equals(inputProduct))
			.anyMatch(Product::isSoldOut)) {
			throw new IllegalArgumentException(ERROR_HEADER + SOLD_OUT_ERROR);
		}
	}

	private static void validatePrice(String inputPrice) {
		if (!MoneyException.isNumber(inputPrice)) {
			throw new IllegalArgumentException(ERROR_HEADER + NATURAL_NUMBER_ERROR_MESSAGE);
		}
		int price = Integer.parseInt(inputPrice);
		MoneyException.validateMoney(price);
		if (!isOver100(price)) {
			throw new IllegalArgumentException(ERROR_HEADER + INVALID_PRICE_ERROR_MESSAGE);
		}
	}

	private static void validateNumber(String inputNumber) {
		if (!MoneyException.isNumber(inputNumber)) {
			throw new IllegalArgumentException(ERROR_HEADER + NATURAL_NUMBER_ERROR_MESSAGE);
		}
		int number = Integer.parseInt(inputNumber);
		if (MoneyException.isNegativeNumber(number)) {
			throw new IllegalArgumentException(ERROR_HEADER + NATURAL_NUMBER_ERROR_MESSAGE);
		}
	}

	private static boolean isRightExpression(String inputProductsInfo) {
		return Pattern.matches(REGULAR_EXPRESSION_PRODUCT_INFO, inputProductsInfo);
	}

	private static boolean containInVendingMachine(String inputProduct,
		List<Product> products) {
		return products.stream().map(Product::getName).collect(Collectors.toList())
			.contains(inputProduct);
	}

	private static boolean isExpensiveThanRemain(List<Product> products, String name, int remain) {
		int numberOfProductsExpensiveThanRemain = (int) products.
			stream().
			filter(product -> product.getName().equals(name)).
			filter(product -> product.getPrice() > remain)
			.count();
		return numberOfProductsExpensiveThanRemain != INITIAL_VALUE;
	}

	private static boolean isOver100(int money) {
		return money >= MINIMUM_PRICE;
	}
}
