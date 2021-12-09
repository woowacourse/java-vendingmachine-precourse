package vendingmachine.view;

public class OutputView {

	private static final String ASK_VENDING_MACHINE_AMOUNT = "자판기가 보유하고 있는 금액을 입력해 주세요.";

	private OutputView() {
	}

	public static void printError(IllegalArgumentException IAE) {
		System.out.println(IAE.getMessage());
	}

	public static void askVendingMachineAmount() {
		System.out.println(ASK_VENDING_MACHINE_AMOUNT);
	}
}
