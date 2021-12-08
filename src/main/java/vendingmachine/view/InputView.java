package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	public static final String VENDING_MACHINE_HAVING_MONEY_INPUT_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";

	public static String inputVendingMachieInput() {
		System.out.println(VENDING_MACHINE_HAVING_MONEY_INPUT_MESSAGE);
		return Console.readLine().trim();
	}
}
