package vendingmachine.service.validator;

import vendingmachine.view.OutputView;
import vendingmachine.view.messages.ErrorMessage;

public class MoneyInputValidator {

	private static final int MINIMUM_MONEY = 0;

	public boolean validateSavedMoneyInput(String MoneyInput) {
		try {
			validateDigit(MoneyInput);
			validateMinimumSavedMoney(MoneyInput);
		} catch (IllegalArgumentException exception) {
			OutputView.printErrorMessage(exception.getMessage());
			return false;
		}
		return true;
	}

	public boolean validateCustomerMoneyInput(String MoneyInput) {
		try {
			validateDigit(MoneyInput);
			validateMinimumCustomerMoney(MoneyInput);
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			return false;
		}
		return true;
	}

	private void validateDigit(String savedMoneyInput) {
		for (int i = 0; i < savedMoneyInput.length(); i++) {
			if (!Character.isDigit(savedMoneyInput.charAt(i))) {
				throw new IllegalArgumentException(ErrorMessage.SAVED_MONEY_CHARACTER_EXCEPTION);
			}
		}
	}

	private void validateMinimumSavedMoney(String savedMoneyInput) {
		if (Integer.parseInt(savedMoneyInput) < MINIMUM_MONEY) {
			throw new IllegalArgumentException(ErrorMessage.SAVED_MONEY_MINIMUM_EXCEPTION);
		}
	}

	private void validateMinimumCustomerMoney(String customerMoneyInput) {
		if (Integer.parseInt(customerMoneyInput) <= MINIMUM_MONEY) {
			throw new IllegalArgumentException(ErrorMessage.CUSTOMER_MONEY_MINIMUM_EXCEPTION);
		}
	}

}
