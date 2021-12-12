package vendingmachine.constant;

public enum Hint {
	INPUT_PRODUCT_LIST("상품명과 가격, 수량을 입력해 주세요."),
	INPUT_DEPOSIT("자판기가 보유하고 있는 금액을 입력해 주세요."),
	INPUT_PRODUCT_NAME("구매할 상품명을 입력해 주세요."),
	INPUT_MONEY("\n투입 금액을 입력해 주세요."),
	MACHINE_HAS("\n자판기가 보유한 동전"),
	DEPOSIT_EACH("%d원 - %d개\n"),
	LEFT_MONEY("\n투입 금액: %d원\n"),
	CHANGE_IS("잔돈");

	private final String hint;

	Hint(String hint) {
		this.hint = hint;
	}

	public String getHint() {
		return hint;
	}
}
