package vendingmachine.utils;

public enum Message {
	GET_AMOUNT_HOLDING_BY_VENDING_MACHINE("자판기가 보유하고 있는 금액을 입력해 주세요."),
	TOTAL_CHANGES("자판기가 보유한 동전"),

	GET_INFORMATION_OF_PRODUCTS("상품명과 가격, 수량을 입력해 주세요."),
	GET_INPUT_MONEY("투입 금액을 입력해 주세요."),
	CURRENT_INPUT_MONEY("투입 금액: "),
	MONEY_UNIT_WON("원"),
	GET_PRODUCT_NAME_TO_BUY("구매할 상품명을 입력해 주세요."),
	REMAIN_CHANGES("잔돈"),
	;

	private final String text;

	Message(final String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}
}
