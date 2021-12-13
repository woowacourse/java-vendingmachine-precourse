package view;

public class InputDisplay {
	private static final String ASK_INPUT_VENDING_MACHINE_CHANGE_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";

	private InputDisplay() {
	}

	public static void askInputVendingMachineChange() {
		System.out.println(ASK_INPUT_VENDING_MACHINE_CHANGE_MESSAGE);
	}

	public static void askInputVendingMachineProduct() {
		System.out.println();
		System.out.println("상품명과 가격, 수량을 입력해 주세요.");
	}

	public static void askInputUserInsertMoney() {
		System.out.println();
		System.out.println("투입 금액을 입력해 주세요.");
	}

	public static void askInputProductNameToBuy() {
		System.out.println("구매할 상품명을 입력해 주세요.");
	}
}
