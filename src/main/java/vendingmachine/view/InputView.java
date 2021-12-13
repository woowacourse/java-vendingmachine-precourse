package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.util.validator.MoneyValidator;

public class InputView {
	private InputView() {
	}

	public static int readAmountMoney() {
		OutputView.printInputHoldingAmountMessage();
		String inputAmountMoney = Console.readLine();
		try {
			MoneyValidator.validate(inputAmountMoney);
		} catch (IllegalArgumentException exception) {
			readAmountMoney();
		}
		return parse(inputAmountMoney);
	}

	private static int parse(String inputAmountMoney) {
		return Integer.parseInt(inputAmountMoney);
	}

	public static String readProducts() {
		OutputView.printInputProductMessage();
		return Console.readLine();
	}
}
