package vendingmachine.util;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.constants.ErrorMessage;

public class Money {
	public static int setMoney() {
		int money;
		try {
			String moneyStr = Console.readLine();
			money = NumberException.checkMoneyException(moneyStr);
		} catch (Exception e) {
			System.out.println(ErrorMessage.ERROR + e.getMessage());
			return setMoney();
		}
		return money;
	}
}
