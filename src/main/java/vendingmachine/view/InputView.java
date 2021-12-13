package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	private InputView() {
	}

	public static String readAmountMoney() {
		OutputView.printInputHoldingAmountMessage();
		return Console.readLine();
	}

	public static String readProducts() {
		OutputView.printInputProductMessage();
		return Console.readLine();
	}

	public static String readInsertMoney() {
		OutputView.printInputInsertMoneyMessage();
		return Console.readLine();
	}

	public static String readPurchaseProduct() {
		OutputView.printInputPurchaseProductMessage();
		return Console.readLine();
	}
}
