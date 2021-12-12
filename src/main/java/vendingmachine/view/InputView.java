package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	public static String inputText() {
		return Console.readLine();
	}

	public static int inputMoney() {
		try {
			return Integer.parseInt(inputText());
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("[ERROR] 금액은 숫자여야 합니다.");
		}
	}
}
