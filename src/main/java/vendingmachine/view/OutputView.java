package vendingmachine.view;

public class OutputView {
	private static final String INPUT_HOLDING_AMOUNT = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	private static final String INPUT_PRODUCT = "상품명과 가격, 수량을 입력해 주세요.";

	private OutputView() {
	}

	public static void printInputHoldingAmountMessage() {
		System.out.println(INPUT_HOLDING_AMOUNT);
	}

	public static void printInputProductMessage() {
		System.out.println(INPUT_PRODUCT);
	}
}
