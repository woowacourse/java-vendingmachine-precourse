package vendingmachine;

import java.util.regex.Pattern;

public class InputValidator {
	private static final String INVALID_TYPE_OF_HOLDING_AMOUNT_MESSAGE = "보유 금액은 숫자만 가능합니다.";
	private static final String INVALID_RANGE_OF_HOLDING_AMOUNT_MESSAGE = "보유 금액은 10으로 나누어 떨어져야 합니다.";
	private static final String INVALID_NUMBER_OF_PRODUCT_MESSAGE = "상품을 1개 이상 입력하세요.";
	private static final String INVALID_PATTERN_OF_PRODUCT_MESSAGE = "[상품명,가격,수량] 형식으로 입력하세요.";
	private static final String INVALID_UNIT_OF_PRODUCT_AMOUNT_MESSAGE = "상품 가격은 10으로 나누어 떨어져야 합니다.";
	private static final String INVALID_RANGE_OF_PRODUCT_AMOUNT_MESSAGE = "상품 가격은 100원 이상이어야 합니다.";
	private static final String INVALID_NUMBER_OF_PRODUCT_AMOUNT_MESSAGE = "상품 수량은 1개 이상이어야 합니다.";
	private static final String INVALID_TYPE_OF_INPUT_AMOUNT_MESSAGE = "투입 금액은 숫자여야 합니다.";
	private static final int UNIT_OF_MONEY = 10;
	private static final int MINIMUM_AMOUNT_OF_PRODUCT = 100;
	private static final int ZERO = 0;

	public static void checkIsValidHoldingAmountInput(String amount) {
		for (int i = 0; i < amount.length(); i++) {
			if (!Character.isDigit(amount.charAt(i))) {
				throw new IllegalArgumentException(INVALID_TYPE_OF_HOLDING_AMOUNT_MESSAGE);
			}
		}
		if (Integer.parseInt(amount) % UNIT_OF_MONEY > ZERO) {
			throw new IllegalArgumentException(INVALID_RANGE_OF_HOLDING_AMOUNT_MESSAGE);
		}
	}

	public static void checkIsValidProductsInput(String products) {
		String[] productArray = products.split(";");
		if (productArray.length == ZERO) {
			throw new IllegalArgumentException(INVALID_NUMBER_OF_PRODUCT_MESSAGE);
		}
		for (String productInfo : productArray) {
			String pattern = "\\[.+,[0-9]+,[0-9]+]";
			if (!Pattern.matches(pattern, productInfo)) {
				throw new IllegalArgumentException(INVALID_PATTERN_OF_PRODUCT_MESSAGE);
			}
			checkIsValidProductInput(productInfo.substring(1, productInfo.length() - 1));
		}
	}

	private static void checkIsValidProductInput(String productInfo) {
		String[] info = productInfo.split(",");
		int amountOfProduct = Integer.parseInt(info[1]);
		if (amountOfProduct % UNIT_OF_MONEY > ZERO) {
			throw new IllegalArgumentException(INVALID_UNIT_OF_PRODUCT_AMOUNT_MESSAGE);
		}
		if (amountOfProduct < MINIMUM_AMOUNT_OF_PRODUCT) {
			throw new IllegalArgumentException(INVALID_RANGE_OF_PRODUCT_AMOUNT_MESSAGE);
		}
		int numberOfProduct = Integer.parseInt(info[2]);
		if (numberOfProduct <= ZERO) {
			throw new IllegalArgumentException(INVALID_NUMBER_OF_PRODUCT_AMOUNT_MESSAGE);
		}
	}

	public static void checkIsValidInputAmountInput(String inputAmount) {
		for (int i = 0; i < inputAmount.length(); i++) {
			if(!Character.isDigit(inputAmount.charAt(i))) {
				throw new IllegalArgumentException(INVALID_TYPE_OF_INPUT_AMOUNT_MESSAGE);
			}
		}
	}
}
