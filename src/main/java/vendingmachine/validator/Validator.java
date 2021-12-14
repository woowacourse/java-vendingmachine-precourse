package vendingmachine.validator;

import vendingmachine.util.Utils;

public class Validator {
	private final static String ERROR_INPUT_MUST_BE_NUMBER = "[ERROR] 금액은 숫자여야 합니다.";
	private final static String ERROR_MONEY_CAN_DIVIDE_INTO_10 = "[ERROR] 금액은 10원 단위여아합니다.";
	private final static String ERROR_CANNOT_EMPTY = "[ERROR] 입력은 공백일 수 없습니다.";
	private final static String ERROR_INPUT_INCORRECT = "[ERROR] 잘못된 상품 정보 입력입니다. 다시 입력해 주세요.";
	private final static String ERROR_INPUT_IS_BIGGER_THAN_100 = "[ERROR] 상품 가격은 100원 이상이어야합니다.";

	public String validateMoney(String money) {
		if (money.isEmpty()) {
			throw new IllegalArgumentException(ERROR_CANNOT_EMPTY);
		}

		if (Utils.isOnlyContainNumber(money)) {
			throw new IllegalArgumentException(ERROR_INPUT_MUST_BE_NUMBER);
		}

		if (Integer.parseInt(money)%10 != 0) {
			throw new IllegalArgumentException(ERROR_MONEY_CAN_DIVIDE_INTO_10);
		}
		return money;
	}

	public String validateProduct(String validateProduct) {
		if (validateProduct.isEmpty()) {
			throw new IllegalArgumentException(ERROR_CANNOT_EMPTY);
		}
		return validateProduct;
	}

	public String validateBuyingProduct(String validateBuyingProduct) {
		if (validateBuyingProduct.isEmpty()) {
			throw new IllegalArgumentException(ERROR_CANNOT_EMPTY);
		}
		return validateBuyingProduct;
	}

	public static void validateProduct(String[] product) throws IllegalArgumentException {
		validateNumberOfInput(product);
		validateOnlyContainNumber(product[1]);
		validateOnlyContainNumber(product[2]);
		validateInputAmountUnder100(product[1]);
		validateInputDivideInto10(product[1]);
	}

	private static void validateOnlyContainNumber(String input) {
		if (Utils.isOnlyContainNumber(input)) {
			throw new IllegalArgumentException(ERROR_INPUT_MUST_BE_NUMBER);
		}
	}

	private static void validateInputAmountUnder100(String input) {
		if (Utils.moneyConverter(input) < 100) {
			throw new IllegalArgumentException(ERROR_INPUT_IS_BIGGER_THAN_100);
		}
	}

	private static void validateInputDivideInto10(String input) {
		if (Integer.parseInt(input) % 10 != 0) {
			throw new IllegalArgumentException(ERROR_MONEY_CAN_DIVIDE_INTO_10);
		}
	}

	private static void validateNumberOfInput(String[] input) {
		if (input.length != 3) {
			throw new IllegalArgumentException(ERROR_INPUT_INCORRECT);
		}
	}
}
