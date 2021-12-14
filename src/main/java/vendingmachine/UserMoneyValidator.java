package vendingmachine;

public class UserMoneyValidator {
	private static final int PRICE_DIVISOR = 10;

	public UserMoneyValidator() {
	}

	public boolean validate(String userMoney) {
		try {
			isNumber(userMoney);
			int userMoneyInInt = Integer.parseInt(userMoney);
			isEqualOrGreaterThanTen(userMoneyInInt);
			isMultipleOfTen(userMoneyInInt);
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			return false;
		}
		return true;
	}

	private void isNumber(String numberInString) throws IllegalArgumentException {
		try {
			Integer.parseInt(numberInString);
		} catch (NumberFormatException exception) {
			throw new IllegalArgumentException(Error.NOT_NUMBER_USER_MONEY.getMessage());
		}
	}

	private void isMultipleOfTen(int money) throws IllegalArgumentException {
		if (money % PRICE_DIVISOR > 0) {
			throw new IllegalArgumentException(Error.NOT_MULTIPLE_OF_TEN_USER_MONEY.getMessage());
		}
	}

	private void isEqualOrGreaterThanTen(int number) throws IllegalArgumentException {
		if (10 > number) {
			throw new IllegalArgumentException(Error.NOT_EQUAL_OR_GREATER_THAN_TEN_USER_MONEY.getMessage());
		}
	}

}
