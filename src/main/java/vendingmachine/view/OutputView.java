package vendingmachine.view;

public class OutputView {
	static final String HOLDING_MONEY_REQUEST_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";

	public static void printHoldingMoneyRequestMessage() {
		System.out.println(HOLDING_MONEY_REQUEST_MESSAGE);
	}
}
