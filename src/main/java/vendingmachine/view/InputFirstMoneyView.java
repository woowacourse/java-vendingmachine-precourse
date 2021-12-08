package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.util.SystemMessage;

public class InputFirstMoneyView implements View {
	@Override
	public void show() {
		System.out.println(SystemMessage.INPUT_FIRST_MONEY);
		int firstMoney = readFirstMoney();
	}

	private int readFirstMoney() {
		String firstMoneyStr = Console.readLine();
		return Integer.parseInt(firstMoneyStr);
	}
}
