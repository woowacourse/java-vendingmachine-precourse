package vendingmachine.validator;

import java.util.List;

import vendingmachine.model.domain.Product;
import vendingmachine.util.Utils;

public class Validator {
	private static final int MINIMUM_AMOUNT = 100;
	private static final int UNIT_OF_WON = 10;
	private static final int NUMBER_OF_PRODUCT_INFORMATION = 3;
	private static final String ERROR_INPUT_MUST_BE_NUMBER = "[ERROR] 금액은 숫자여야 합니다.";
	private static final String ERROR_MONEY_CAN_DIVIDE_INTO_10 = "[ERROR] 금액은 10원 단위여아합니다.";
	private static final String ERROR_CANNOT_EMPTY = "[ERROR] 입력은 공백일 수 없습니다.";
	private static final String ERROR_INPUT_INCORRECT = "[ERROR] 잘못된 상품 정보 입력입니다. 다시 입력해 주세요.";
	private static final String ERROR_INPUT_IS_BIGGER_THAN_100 = "[ERROR] 상품 가격은 100원 이상이어야합니다.";
	public static final String ERROR_NOT_EXISTED_PRODUCT = "[ERROR] 존재하지 않는 상품 이름입니다.";
	public static final String ERROR_NOT_EXISTED_COIN = "[ERROR] 존재하지 않는 코인입니다.";
	public static final String ERROR_DUPLICATE_PRODUCT_EXISTED = "[ERROR] 중복된 상품 명이 존재합니다.";

	public String validateMoney(String money) {
		isInputEmpty(money);
		isInputOnlyContainNumber(money);
		isInputDividedInto10(money);

		return money;
	}

	public String validateProduct(String validateProduct) {
		isInputEmpty(validateProduct);

		return validateProduct;
	}

	public String validateBuyingProduct(String validateBuyingProduct) {
		isInputEmpty(validateBuyingProduct);

		return validateBuyingProduct;
	}

	public static void validateProduct(List<String> product) {
		isNumberOfInputValid(product);
		isInputOnlyContainNumber(product.get(1));
		isInputOnlyContainNumber(product.get(2));
		isInputAmountUnder100(product.get(1));
		isInputDividedInto10(product.get(1));
	}

	public static void validateProductList(List<String> distinctProductList, List<Product> productList) {
		if (distinctProductList.size() != productList.size()) {
			throw new IllegalArgumentException(ERROR_DUPLICATE_PRODUCT_EXISTED);
		}
	}

	private static void isInputOnlyContainNumber(String input) {
		if (Utils.isOnlyContainNumber(input)) {
			throw new IllegalArgumentException(ERROR_INPUT_MUST_BE_NUMBER);
		}
	}

	private static void isInputAmountUnder100(String input) {
		if (Utils.moneyConverter(input) < MINIMUM_AMOUNT) {
			throw new IllegalArgumentException(ERROR_INPUT_IS_BIGGER_THAN_100);
		}
	}

	private static void isInputDividedInto10(String input) {
		if (Integer.parseInt(input) % UNIT_OF_WON != 0) {
			throw new IllegalArgumentException(ERROR_MONEY_CAN_DIVIDE_INTO_10);
		}
	}

	private static void isNumberOfInputValid(List<String> input) {
		if (input.size() != NUMBER_OF_PRODUCT_INFORMATION) {
			throw new IllegalArgumentException(ERROR_INPUT_INCORRECT);
		}
	}

	private static void isInputEmpty(String input) {
		if (input.isEmpty()) {
			throw new IllegalArgumentException(ERROR_CANNOT_EMPTY);
		}
	}
}
