package vendingmachine;

public class InitialMoneyValidator extends NumberValidator {
	public InitialMoneyValidator() {
	}

	public boolean validate(String initialMoney) {
		try {
			isNumber(initialMoney, Error.NOT_NUMBER_INITIAL_MONEY);
			int initialMoneyInNumber = Integer.parseInt(initialMoney);
			isMoreThanThreshold(initialMoneyInNumber, Constants.TEN, Error.NOT_MORE_THAN_TEN_INITIAL_MONEY);
			isMultipleOfTen(initialMoneyInNumber, Error.NOT_MULTIPLE_OF_TEN_INITIAL_MONEY);
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			return false;
		}
		return true;
	}
}
