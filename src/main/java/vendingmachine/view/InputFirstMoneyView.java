package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
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
	}

	private int readFirstMoney() {
		String firstMoneyStr = Console.readLine();
		int firstMoney;
		try {
			firstMoney = Integer.parseInt(firstMoneyStr);
		} catch (Exception e) {
			throw new IllegalArgumentException(SystemMessage.ERROR_IS_NOT_INTEGER);
		}
		return firstMoney;
	}
}
