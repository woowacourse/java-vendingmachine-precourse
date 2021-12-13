package vendingmachine.validator;

import java.util.regex.Pattern;

public class Validator {
	String ERROR_MONEY_IS_INTEGER = "[ERROR] 금액은 숫자여야 합니다.";

	public String validateMoney(String money) {
		String numberOnly = "^[0-9]+$";

		if (!Pattern.matches(numberOnly, money)) {
			throw new IllegalArgumentException(ERROR_MONEY_IS_INTEGER);
		}
		return money;
	}
}
