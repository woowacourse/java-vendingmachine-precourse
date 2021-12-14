package vendingmachine.view;

public class VendingMachineAccountView {
	private static final String INPUT_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	private static final String VENDING_MACHINE_COIN_MESSAGE = "자판기가 보유한 동전";

	public static void printInputGuide() {
		System.out.println(INPUT_MESSAGE);
	}

	public static void printVendingMachineCoin() {
		System.out.println(VENDING_MACHINE_COIN_MESSAGE);
	}

}
