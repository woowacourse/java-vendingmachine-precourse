package vendingmachine;

public class InitialMoneyValidator {
	public InitialMoneyValidator() {

	}

	public boolean validate(String initialMoney) {
		try {
			isNumber(initialMoney);
			int initialMoneyInNumber = Integer.parseInt(initialMoney);
			isEqualOrGreaterThanTen(initialMoneyInNumber);
			isMultipleOfTen(initialMoneyInNumber);
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			return false;
		}
		return true;
	}

	private void isNumber(String money) throws IllegalArgumentException {
		try {
			Integer.parseInt(money);
		} catch (NumberFormatException exception) {
			throw new IllegalArgumentException(Error.NOT_NUMBER_INITIAL_MONEY.getMessage());
		}
	}

	private void isMultipleOfTen(int money) throws IllegalArgumentException {
		if (money % 10 > 0) {
			throw new IllegalArgumentException(Error.NOT_MULTIPLE_OF_TEN_INITIAL_MONEY.getMessage());
		}
	}

	private void isEqualOrGreaterThanTen(int money) throws IllegalArgumentException {
		if (money < 10) {
			throw new IllegalArgumentException(Error.NOT_EQUAL_OR_GREATER_THAN_TEN_INITIAL_MONEY.getMessage());
		}
	}
}
