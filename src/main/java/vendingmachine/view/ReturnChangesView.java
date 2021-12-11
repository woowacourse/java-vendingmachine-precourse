package vendingmachine.view;

import vendingmachine.Application;
import vendingmachine.util.PublicConst;
import vendingmachine.util.SystemMessage;

public class ReturnChangesView implements View {
	@Override
	public void show() {
		int money = Application.controller.getMoney();
		printMoneyAndMessage(money);

	}

	private void printMoneyAndMessage(int money) {
		System.out.println(SystemMessage.SHOW_INPUT_MONEY + money + PublicConst.MONETARY_UNIT);
		System.out.println(SystemMessage.RETURN_CHANGES);
	}
}
