package vendingmachine;

import camp.nextstep.edu.missionutils.Console;

public class InitialMoney {
	private InitialMoney() {
	}

	public static int get() throws IllegalArgumentException {
		return Integer.parseInt(set());
	}

	private static String set() throws IllegalArgumentException {
		Guide.INITIAL_MONEY_REQUEST.println();
		String moneyInString = Console.readLine();
		InitialMoneyValidator validator = new InitialMoneyValidator();
		if (!validator.validate(moneyInString)) {
			return set();
		}
		return moneyInString;
	}
}
