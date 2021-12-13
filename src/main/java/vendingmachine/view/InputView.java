package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	private final static String INPUT_AMOUNT_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	private final static String INPUT_ITEM_MESSAGE = "\n상품명과 가격, 수량을 입력해 주세요.";
	private final static String INPUT_USER_AMOUNT_MESSAGE = "\n투입 금액을 입력해 주세요.";

	public String getInputAmount() {
		printInputAmountMessage();
		return Console.readLine();
	}

	private void printInputAmountMessage() {
		System.out.println(INPUT_AMOUNT_MESSAGE);
	}

	public String getInputItem() {
		printInputItemMessage();
		return Console.readLine();
	}

	private void printInputItemMessage() {
		System.out.println(INPUT_ITEM_MESSAGE);
	}

	public String getInputUserAmount() {
		printInputUserAmountMessage();
		return Console.readLine();
	}

	private void printInputUserAmountMessage() {
		System.out.println(INPUT_USER_AMOUNT_MESSAGE);
	}
}
