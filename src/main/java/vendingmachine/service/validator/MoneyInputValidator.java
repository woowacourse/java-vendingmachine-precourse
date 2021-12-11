package vendingmachine.service.validator;

public class MoneyInputValidator {

	private static final int MINIMUM_MONEY = 0;

	public boolean validateSavedMoneyInput(String MoneyInput) {
		try {
			validateDigit(MoneyInput);
			validateMinimumSavedMoney(MoneyInput);
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
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
				throw new IllegalArgumentException("보유 금액 입력은 숫자여야 합니다.");
			}
		}
	}

	private void validateMinimumSavedMoney(String savedMoneyInput) {
		if (Integer.parseInt(savedMoneyInput) < MINIMUM_MONEY) {
			throw new IllegalArgumentException("보유 금액은 0원 이상이어야 합니다.");
		}
	}

	private void validateMinimumCustomerMoney(String customerMoneyInput) {
		if (Integer.parseInt(customerMoneyInput) <= MINIMUM_MONEY) {
			throw new IllegalArgumentException("투입 금액은 0원 초과이어야 합니다.");
		}
	}

}
