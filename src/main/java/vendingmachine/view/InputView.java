package vendingmachine.view;

public class InputView {
	public static final String ASK_HOLDING_MONEY = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	public static final String ASK_ITEM_INFORMATION = "상품명과 가격, 수량을 입력해 주세요.";
	public static final String ASK_INPUT_MONEY = "투입 금액을 입력해 주세요.";

	public static void askHoldingMoney() {
		System.out.println(ASK_HOLDING_MONEY);
	}

	public static void askItemInform() {
		System.out.println(ASK_ITEM_INFORMATION);
	}

	public static void askInputMoney() {
		System.out.println();
		System.out.println(ASK_INPUT_MONEY);
	}
}
