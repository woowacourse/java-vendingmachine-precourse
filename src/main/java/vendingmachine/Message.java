package vendingmachine;

public enum Message {
	INITIAL_MONEY_REQUEST("자판기가 보유하고 있는 금액을 입력해 주세요."),
	ITEM_REQUEST("상품명과 가격, 수량을 입력해 주세요."),
	USER_MONEY_REQUEST("투입 금액을 입력해 주세요."),
	PURCHASE_REQUEST("구매할 상품명을 입력해 주세요."),
	INITIAL_COIN_CHANGE_SHOW("자판기가 보유한 동전"),
	LEFT_MONEY_SHOW("투입 금액:"),
	USER_CHANGE_SHOW("잔돈");

	private final String message;

	Message(final String message) {
		this.message = message;
	}

	public void print() {
		System.out.print(message);
	}

	public void println() {
		System.out.println(message);
	}
}
