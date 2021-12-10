package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	private static final String INPUT_HAVING_MONEY = "자판기가 보유하고 있는 금액을 입력해 주세요.";

	public static int getHavingMoney() {
		System.out.println(INPUT_HAVING_MONEY);
		String input = Console.readLine();
		return Integer.parseInt(input);
	}
}
