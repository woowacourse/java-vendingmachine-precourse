package vendingmachine.util.finalstring;

public enum Message {
    ASK_MACHINE_BALANCE_MESSAGE("자판기가 보유하고 있는 금액을 입력해 주세요."),
    ASK_ALL_PRODUCT_INFO_MESSAGE("상품명과 가격, 수량을 입력해 주세요."),
    ASK_CONSUMER_BALANCE_MESSAGE("투입 금액을 입력해 주세요."),
    ASK_PRODUCT_NAME_MESSAGE("구매할 상품명을 입력해 주세요.")
    ;

    private String content;

    Message(String content) {
        this.content = content;
    }

    public String getMessage() {
        return this.content;
    }
}
