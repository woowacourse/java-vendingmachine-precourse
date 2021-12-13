package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	private final static String INPUT_AMOUNT_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";

	public String getInputAmount() {
		printInputAmountMessage();
		return Console.readLine();
	}

	private void printInputAmountMessage() {
		System.out.println(INPUT_AMOUNT_MESSAGE);
	}

}
