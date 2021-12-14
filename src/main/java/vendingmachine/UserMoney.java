package vendingmachine;

import camp.nextstep.edu.missionutils.Console;

public class UserMoney {
	private UserMoney() {
	}

	public static int get() {
		String userMoneyInString = set();
		return Integer.parseInt(userMoneyInString);
	}

	private static String set() {
		Guide.USER_MONEY_REQUEST.println();
		String userMoneyInString = Console.readLine();
		UserMoneyValidator validator = new UserMoneyValidator();
		if (!validator.validate(userMoneyInString)) {
			return set();
		}
		return userMoneyInString;
	}
}
