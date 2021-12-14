package vendingmachine;

public class UserMoneyValidator extends NumberValidator {
	public UserMoneyValidator() {
	}

	public boolean validate(String userMoney) {
		try {
			isNumber(userMoney, Error.NOT_NUMBER_USER_MONEY);
			int userMoneyInInt = Integer.parseInt(userMoney);
			isMoreThanThreshold(userMoneyInInt, Constants.TEN, Error.NOT_MORE_THAN_TEN_USER_MONEY);
			isMultipleOfTen(userMoneyInInt, Error.NOT_MULTIPLE_OF_TEN_USER_MONEY);
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			return false;
		}
		return true;
	}
}
