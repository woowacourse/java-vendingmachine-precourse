package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.Application;
import vendingmachine.controller.ViewMappingKey;
import vendingmachine.util.MoneyValidator;
import vendingmachine.util.PublicConst;
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
		Application.controller.view(ViewMappingKey.SHOW_FIRST_MONEY);
	}

	private int readFirstMoney() {
		String firstMoneyStr = Console.readLine().replaceAll(PublicConst.BLANK_REGEX, PublicConst.EMPTY_STRING);
		MoneyValidator.validate(firstMoneyStr);

		return MoneyValidator.validate(firstMoneyStr);
	}
}
