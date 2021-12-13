package vendingmachine.constant;

public enum Input {
    SEMICOLON(";"),
    OPEN_BRACKET("["),
    CLOSE_BRACKET("]"),
    COMMA(","),

    COIN_MONEY_GUIDE_MESSAGE("자판기가 보유하고 있는 금액을 입력해 주세요."),
    PRODUCT_GUIDE_MESSAGE("상품명과 가격, 수량을 입력해 주세요."),
    PURCHASE_MONEY_GUIDE_MESSAGE("투입 금액을 입력해 주세요."),
    PRODUCT_PURCHASE_GUIDE_MESSAGE("구매할 상품명을 입력해 주세요.");

    private final String text;

    Input(final String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}