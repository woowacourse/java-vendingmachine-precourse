package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	public static String getHoldingAmountInput() {
		OutputView.printHoldingAmountRequestMessage();
		String input = Console.readLine();
		return input;
	}

	public static String getProductsInput() {
		OutputView.printProductInputRequestMessage();
		String input = Console.readLine();
		return input;
	}

	public static String getInputAmountInput() {
		OutputView.printInputAmountRequestMessage();
		String input = Console.readLine();
		return input;
	}

	public static String getProductNameToBuyInput() {
		OutputView.printProductNameToBuyRequestMessage();
		String input = Console.readLine();
		return input;
	}
}
