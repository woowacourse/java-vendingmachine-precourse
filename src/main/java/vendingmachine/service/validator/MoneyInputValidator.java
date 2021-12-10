package vendingmachine.service.validator;

public class MoneyInputValidator {

	private static final int MINIMUM_MONEY = 0;

	public void validateMoneyInput(String savedMoneyInput) {
		try {
			validateDigit(savedMoneyInput);
			validateMinimumMoney(savedMoneyInput);
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
		}
	}

	private void validateDigit(String savedMoneyInput) {
		for (int i = 0; i < savedMoneyInput.length(); i++) {
			if (!Character.isDigit(savedMoneyInput.charAt(i))) {
				throw new IllegalArgumentException("보유 금액 입력은 숫자여야 합니다.");
			}
		}
	}
}
