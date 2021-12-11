package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	private InputView() {
	}

	public static int readAmountMoney() {
		OutputView.printInputHoldingAmountMessage();
		String inputAmountMoney = Console.readLine();
		return parse(inputAmountMoney);
	}

	private static int parse(String inputAmountMoney) {
		return Integer.parseInt(inputAmountMoney);
	}
}
