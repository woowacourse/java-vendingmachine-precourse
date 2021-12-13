package vendingmachine.validator;

import static vendingmachine.NumberConstant.*;

public class MoneyValidator {

	private static final String NOT_INTEGER_ERROR = "[ERROR] 입력값이 숫자여야 합니다.\n";
	private static final String NOT_MULTIPLE_OF_TEN_ERROR = "[ERROR] 금액은 10원 단위여야 합니다.\n";

	private static final String INTEGER = "-?\\d+";

	public void validateMoney(int money) {
		if (money <= ZERO || money % TEN != ZERO) {
			throw new IllegalArgumentException(NOT_MULTIPLE_OF_TEN_ERROR);
		}
	}

	public int isInteger(String input) {
		if (!input.matches(INTEGER)) {
			throw new IllegalArgumentException(NOT_INTEGER_ERROR);
		}

		return Integer.parseInt(input);
	}
}
