package vendingmachine.view;

public class ConsumerMessage {
	public static final String PUT_MONEY = "\n투입 금액을 입력해 주세요.";

	public static void printInputMessage() {
		System.out.println(PUT_MONEY);
	}
}
