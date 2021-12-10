package vendingmachine.utils;

public enum Message {
	GET_AMOUNT_HOLDING_BY_VENDING_MACHINE("자판기가 보유하고 있는 금액을 입력해 주세요."),
	TOTAL_CHANGES("자판기가 보유한 동전"),
	;

	private final String text;

	Message(final String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}
}
