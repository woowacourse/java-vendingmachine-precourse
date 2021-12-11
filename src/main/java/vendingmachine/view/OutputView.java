package vendingmachine.view;

public class OutputView {

	public static void printError(String error) {
		System.out.println(error);
	}

	public static void printHoldingCashRequest() {
		System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
	}
}
