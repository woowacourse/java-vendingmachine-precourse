package vendingmachine.constant;

public enum Output {
    WON("원"),
    DELIMITER(" - "),
    UNIT("개"),
    VENDING_MACHINE_HAS_COIN_GUIDE_MESSAGE("자판기가 보유한 동전"),
    PURCHASE_MONEY("투입 금액: "),
    CHANGE("잔돈");

    private final String text;

    Output(final String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
