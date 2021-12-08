package vendingmachine.util.validator;

import vendingmachine.util.ErrorMessage;
import vendingmachine.util.InputCondition;
import vendingmachine.util.Symbol;

public class MoneyValidator {

	public void validateMachineMoney(String input) {
		validateNumber(input);
		validateNotMinus(input);
		validateDivideByTen(input);
	}

	private void validateNumber(String input) {
		if (!input.matches(InputCondition.NUMBER_REGEX)) {
			throw new IllegalArgumentException(ErrorMessage.ERROR.getMessage()
				+ Symbol.SPACE + ErrorMessage.NOT_NUMBER_ERROR.getMessage());
		}
	}

	private void validateNotMinus(String input) {
		int money = Integer.parseInt(input);
		if (money < InputCondition.LOWER_LIMIT_MONEY) {
			throw new IllegalArgumentException(ErrorMessage.ERROR.getMessage()
				+ Symbol.SPACE + ErrorMessage.NOT_MINUS_NUMBER.getMessage());
		}
	}

	private void validateDivideByTen(String input) {
		int money = Integer.parseInt(input);
		if (money % InputCondition.MIN_MONEY_UNIT != InputCondition.ZERO) {
			throw new IllegalArgumentException(ErrorMessage.ERROR.getMessage()
				+ Symbol.SPACE + ErrorMessage.NOT_DIVIDED_BY_TEN.getMessage());
		}
	}
}
