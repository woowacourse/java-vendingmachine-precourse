package vendingmachine.utils.message;

public enum SystemMessage {
	GET_TOTAL_AMOUNT_OF_VENDING_MACHINE("자판기가 보유하고 있는 금액을 입력해 주세요."),
	TOTAL_CHANGES("자판기가 보유한 동전"),
	GET_INFORMATION_OF_PRODUCTS("상품명과 가격, 수량을 입력해 주세요."),
	GET_INSERT_MONEY("투입 금액을 입력해 주세요."),
	CURRENT_INSERT_MONEY("투입 금액: "),
	MONEY_UNIT_WON("원"),
	GET_PRODUCT_NAME_TO_BUY("구매할 상품명을 입력해 주세요."),
	REMAIN_CHANGES("잔돈"),
	DASH_DELIMITER(" - "),
	AMOUNT_UNIT("개"),
	;

	private final String text;

	SystemMessage(final String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	@Override
	public String toString() {
		return text;
	}
}
