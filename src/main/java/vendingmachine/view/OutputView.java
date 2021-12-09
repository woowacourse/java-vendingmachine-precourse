package vendingmachine.view;

public class OutputView {
	private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";
	private static final String INPUT_VENDING_MACHINE_BALANCE_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";

	public static void printError(String message) {
		System.out.println(ERROR_MESSAGE_PREFIX + message);
	}

	public static void printInputVendingMachineBalance() {
		System.out.println(INPUT_VENDING_MACHINE_BALANCE_MESSAGE);
	}
}
