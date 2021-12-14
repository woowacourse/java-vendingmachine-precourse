package vendingmachine.message;

public enum Message {

	ENTER_COSTS_GOING_TO_HAS_MACHINE("자판기가 보유하고 있는 금액을 입력해 주세요."),
	PRINT_COIN_IN_MACHINE("자판기가 보유한 동전"),
	ENTER_PRODUCT("상품명과 가격, 수량을 입력해 주세요."),
	ENTER_INPUT_COSTS("투입 금액을 입력해 주세요."),
	PRINT_INPUT_COSTS("투입 금액: "),
	ENTER_PRODUCT_GOING_TO_PURCHASE("구매할 상품명을 입력해 주세요."),
	PRINT_BALANCE("잔돈"),
	PRINT_AMOUNT_UNIT("개"),
	PRINT_MONEY_UNIT("원"),
	LINE_BREAKER("\n"),
	REST_MONEY_SEPARATOR(" - ");


	private String message;

	Message(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
