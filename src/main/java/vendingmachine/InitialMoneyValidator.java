package vendingmachine;

public class InitialMoneyValidator extends Validator {
	private final String initialMoney;

	public InitialMoneyValidator(String initialMoney) {
		this.initialMoney = initialMoney;
	}

	@Override
	public boolean validate() {
		try {
			isNumber(this.initialMoney);
			int initialMoneyInNumber = Integer.parseInt(this.initialMoney);
			isEqualOrGreaterThenTen(initialMoneyInNumber);
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

	private void isEqualOrGreaterThenTen(int money) throws IllegalArgumentException {
		if (money < 10) {
			throw new IllegalArgumentException(Error.NOT_EQUAL_OR_GREATER_THAN_TEN_INITIAL_MONEY.getMessage());
		}
	}
}
