package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.Application;
import vendingmachine.util.MoneyValidator;
import vendingmachine.util.SystemMessage;

public class InputMoneyView implements View {
	@Override
	public void show() {
		System.out.println(SystemMessage.INPUT_MONEY);
		int money;
		try {
			money = readMoney();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			show();
			return;
		}

		Application.controller.inputMoney(money);
	}

	private int readMoney() {
		String moneyStr = Console.readLine().replaceAll("\\s+", "");
		return MoneyValidator.validate(moneyStr);
	}
}
