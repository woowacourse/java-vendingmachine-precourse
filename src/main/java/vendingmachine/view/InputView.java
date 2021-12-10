package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	public static String getHoldingAmountInput() {
		OutputView.printHoldingMoneyRequestMessage();
		String input = Console.readLine();
		return input;
	}

	public static String getProductsInput() {
		String input = Console.readLine();
		return input;
	}

	public static String getInputMoneyInput() {
		String input = Console.readLine();
		return input;
	}

	public static String getProductNameToBuyInput() {
		OutputView.printProductNameToBuyRequestMessage();
		String input = Console.readLine();
		return input;
	}
}
