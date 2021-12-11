package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.validator.Validator;

public class Input {
	static final String MSG_GET_MONEY_IN_MACHINE = "자판기가 보유하고 있는 금액을 입력해 주세요.";

	public static int getMoneyInMachine() {
		String moneyInVendingMachine;
		do {
			System.out.println(MSG_GET_MONEY_IN_MACHINE);
			moneyInVendingMachine = Console.readLine();
		} while (Validator.checkMoneyInMachine(moneyInVendingMachine));
		return Integer.parseInt(moneyInVendingMachine);
	}
}
