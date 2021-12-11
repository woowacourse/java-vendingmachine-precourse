package vendingmachine.view;

public class OutputView {
	public final static String HOLDING_MONEY_ERROR = "[ERROR] 금액은 0이상의 숫자여야 합니다.";

	public static void printMoneyError() {
		System.out.println(HOLDING_MONEY_ERROR);
	}
}
