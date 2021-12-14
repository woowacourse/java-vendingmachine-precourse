package vendingmachine.view.input.validator;

import vendingmachine.domain.machine.money.MoneyCondition;
import vendingmachine.exception.MoneyNotMultipleOfTenMessageException;
import vendingmachine.exception.MoneyNotPositiveMessageException;

public class MoneyValidator {

	private static final MoneyValidator instance = new MoneyValidator();

	public static void validate(int money) {
		instance.validateMoneyIsPositive(money);
		instance.validateMoneyIsMultipleOfTen(money);
	}

	private void validateMoneyIsPositive(int balance) {
		if (isNumberNotPositive(balance)) {
			throw new MoneyNotPositiveMessageException();
		}
	}

	private boolean isNumberNotPositive(int number) {
		return (number <= 0);
	}

	private void validateMoneyIsMultipleOfTen(int balance) {
		if (isNumberNotMultipleOfTen(balance)) {
			throw new MoneyNotMultipleOfTenMessageException();
		}
	}

	private boolean isNumberNotMultipleOfTen(int number) {
		return MoneyCondition.isNotDivide(number);
	}

}
