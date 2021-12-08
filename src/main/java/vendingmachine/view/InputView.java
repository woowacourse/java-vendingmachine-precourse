package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	public static int inputHoldingAmountMoney() {
		String input = Console.readLine();
		return Integer.parseInt(input);
	}
}
