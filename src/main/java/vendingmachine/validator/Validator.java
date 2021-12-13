package vendingmachine.validator;

import java.util.regex.Pattern;

public class Validator {
	String ERROR_MONEY_IS_INTEGER = "[ERROR] 금액은 숫자여야 합니다.";
	String ERROR_MONEY_CAN_DIVIDE_INTO_10 = "[ERROR] 금액은 10원 단위여아합니다.";
	String ERROR_CANNOT_EMPTY = "[ERROR] 입력은 공백일 수 없습니다.";

	public String validateMoney(String money) {
		String numberOnly = "^[0-9]+$";

		if (money.isEmpty()) {
			throw new IllegalArgumentException(ERROR_CANNOT_EMPTY);
		}

		if (!Pattern.matches(numberOnly, money)) {
			throw new IllegalArgumentException(ERROR_MONEY_IS_INTEGER);
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
}
