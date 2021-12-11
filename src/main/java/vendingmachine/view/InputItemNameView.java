package vendingmachine.view;

import vendingmachine.Application;
import vendingmachine.util.PublicConst;
import vendingmachine.util.SystemMessage;

public class InputItemNameView implements View {

	@Override
	public void show() {
		showInputMoney();
		System.out.println(SystemMessage.INPUT_ITEM_NAME);

	}

	private void showInputMoney() {
		System.out.print(SystemMessage.SHOW_INPUT_MONEY);
		int money = Application.controller.getMoney();
		System.out.println(money + PublicConst.MONETARY_UNIT);
	}
}
