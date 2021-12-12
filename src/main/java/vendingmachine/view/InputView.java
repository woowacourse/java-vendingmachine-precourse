package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.constant.ErrorConst;

public class InputView {
	public static String inputText() {
		return Console.readLine();
	}

	public static int inputMoney() {
		try {
			return Integer.parseInt(inputText());
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ErrorConst.MONEY_IS_NUMBER);
		}
	}
}
