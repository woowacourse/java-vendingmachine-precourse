package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.Application;
import vendingmachine.controller.ViewMappingKey;
import vendingmachine.util.MoneyValidator;
import vendingmachine.util.PublicConst;
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
			reshow();
			return;
		}

		inputMoney(money);
		goInputItemNameView();
	}

	private int readMoney() {
		String moneyStr = Console.readLine().replaceAll(PublicConst.BLANK_REGEX, PublicConst.EMPTY_STRING);
		return MoneyValidator.validate(moneyStr);
	}

	private void inputMoney(int money) {
		Application.controller.inputMoney(money);
	}

	private void goInputItemNameView() {
		Application.controller.view(ViewMappingKey.INPUT_ITEM_NAME);
	}

	private void reshow() {
		Application.controller.view(ViewMappingKey.INPUT_MONEY);
	}
}
