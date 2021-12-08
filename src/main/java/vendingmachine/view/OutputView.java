package vendingmachine.view;

public class OutputView {

	private static final String ERROR_FORM = "[ERROR] : ";
	private static final String INPUT_MONEY_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";

	public static void printError(Exception exception) {
		System.out.println(ERROR_FORM + exception.getMessage());
	}

	public static void askInputMoneyOfVendingMachine() {
		System.out.println(INPUT_MONEY_MESSAGE);
	}

}
