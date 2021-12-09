package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.Application;
import vendingmachine.util.MoneyValidator;
import vendingmachine.util.SystemMessage;

public class InputFirstMoneyView implements View {
	@Override
	public void show() {
		System.out.println(SystemMessage.INPUT_FIRST_MONEY);
		int firstMoney;
		try {
			firstMoney = readFirstMoney();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			show();
			return;
		}
		Application.controller.createFirstCoins(firstMoney);
	}

	private int readFirstMoney() {
		String firstMoneyStr = Console.readLine();
		MoneyValidator.validate(firstMoneyStr);

		return MoneyValidator.validate(firstMoneyStr);
	}
}
