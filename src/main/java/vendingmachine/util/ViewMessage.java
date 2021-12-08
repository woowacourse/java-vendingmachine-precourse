package vendingmachine.util;

public enum ViewMessage {
	INPUT_MACHINE_MONEY("자판기가 보유하고 있는 금액을 입력해 주세요."),
	INPUT_ITEM_INFO("상품명과 가격, 수량을 입력해 주세요."),
	INPUT_PAY_MONEY("투입 금액을 입력해 주세요."),
	INPUT_ITEM_TO_BUY("구매할 상품명을 입력해 주세요."),

	OUTPUT_MACHINE_MONEY("자판기가 보유한 동전"),
	OUTPUT_PAY_MONEY("투입 금액"),
	OUTPUT_SMALL_CHANGE("잔돈");

	private final String message;

	ViewMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
