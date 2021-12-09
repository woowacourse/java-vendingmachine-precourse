package vendingmachine;

/**
 * 자판기의 출력창 역할을 하는 view class
 *
 * @author YJGwon
 * @version 1.0
 * @since 1.0
 */
public class Display {
	private static final String HOLDING_AMOUNT_QUESTION = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	private static final String ERROR_HEADER = "[ERROR]";

	public void askHoldingAmount() {
		System.out.println(HOLDING_AMOUNT_QUESTION);
	}

	public void printError(Exception e) {
		System.out.printf("%s %s%n", ERROR_HEADER, e.getMessage());
	}
}
