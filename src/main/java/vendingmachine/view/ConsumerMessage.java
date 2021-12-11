package vendingmachine.view;

import vendingmachine.domain.Consumer;

public class ConsumerMessage {
	public static final String PUT_MONEY = "\n투입 금액을 입력해 주세요.";
	public static final String INPUT_MONEY = "\n투입 금액: ";
	public static final String MONEY_UNIT = "원";

	public static void printInputMoneyMessage() {
		System.out.println(PUT_MONEY);
	}

	public static void printCurrentStatusMessage(Consumer consumer) {
		System.out.println(INPUT_MONEY + consumer.getMoney() + MONEY_UNIT);
	}
}
