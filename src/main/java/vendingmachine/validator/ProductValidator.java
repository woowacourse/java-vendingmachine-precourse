package vendingmachine.validator;

public class ProductValidator {

	private static final String OPENING_BRACKET = "[";
	private static final String CLOSING_BRACKET = "]";
	private static final String PRODUCT_CRITERIA = ";";
	private static final String ARGUMENT_CRITERIA = ",";
	private static final int NUMBER_OF_ARGUMENTS = 3;
	private static final String KOREAN_REGEX = ".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*";
	private static final int PRICE_MINIMUM_LIMIT = 100;

	public static boolean isValidProducts(String input) {
		String[] products = input.split(PRODUCT_CRITERIA, -1);

		checkProductExist(products.length);

		for (String product : products) {
			checkProductInputForm(product);
		}

		return true;
	}

	private static void checkProductExist(int numberOfProducts) {
		if (numberOfProducts == 0) {
			throw new IllegalArgumentException(
				"각 상품은 " + PRODUCT_CRITERIA + "로 구분 지어져야하고, 상품은 1개 이상이어야 합니다.");
		}
	}

	private static void checkProductInputForm(String product) {
		checkBracketExistAndValid(product);
		checkProductArguments(product);
	}

	private static void checkBracketExistAndValid(String product) {
		if (!product.startsWith(OPENING_BRACKET) || !product.endsWith(CLOSING_BRACKET)) {
			throw new IllegalArgumentException(
				"각 상품은" + OPENING_BRACKET + CLOSING_BRACKET + "으로 감싸져야 합니다.");
		}
	}

	private static void checkProductArguments(String product) {
		String[] productArguments = product.split(ARGUMENT_CRITERIA, -1);

		checkArgumentsLength(productArguments.length);

		String productName = productArguments[0];
		checkProductName(productName);

		String productPrice = productArguments[1];
		checkProductPrice(productPrice);

		String numberOfProducts = productArguments[2];
		checkNumberOfProducts(numberOfProducts);
	}

	private static void checkArgumentsLength(int argumentsLength) {
		if (argumentsLength != NUMBER_OF_ARGUMENTS) {
			throw new IllegalArgumentException(
				"상품 정보는 " + NUMBER_OF_ARGUMENTS + "개이어야 하고, " + ARGUMENT_CRITERIA + "로 구분 지어져야 합니다.");
		}
	}

	private static void checkProductName(String productName) {
		if (!productName.matches(KOREAN_REGEX)) {
			throw new IllegalArgumentException("상품명은 한글만 허용됩니다.");
		}
	}

	private static void checkProductPrice(String productPrice) {
		for (int i = 0; i < productPrice.length(); i++) {
			if (!Character.isDigit(productPrice.charAt(i))) {
				throw new IllegalArgumentException("상품 가격은 자연수만 허용됩니다.");
			}
		}

		if (!productPrice.endsWith("0")) {
			throw new IllegalArgumentException("상품 가격은 10으로 나누어 떨어져야 합니다.");
		}

		if (Integer.parseInt(productPrice) < PRICE_MINIMUM_LIMIT) {
			throw new IllegalArgumentException("상품 가격은 " + PRICE_MINIMUM_LIMIT + "원 이상 이어야합니다.");
		}
	}

	private static void checkNumberOfProducts(String numberOfProducts) {
		for (int i = 0; i < numberOfProducts.length(); i++) {
			if (!Character.isDigit(numberOfProducts.charAt(i))) {
				throw new IllegalArgumentException("상품 수량은 자연수만 허용됩니다.");
			}
		}
	}

}
