package vendingmachine.constant;

public enum SystemMessage {
    GET_MACHINE_MONEY_MESSAGE("자판기가 보유하고 있는 금액을 입력해 주세요."),
    COIN_STATUS_MESSAGE("자판기가 보유한 동전"),
    GET_MERCHANDISE_MESSAGE("상품명과 가격, 수량을 입력해 주세요."),
    GET_INPUT_MONEY_MESSAGE("투입 금액을 입력해주세요."),
    CHOICE_MERCHANDISE_MESSAGE("구매할 상품명을 입력해 주세요.");

    private String message;

    SystemMessage(String message) {
        this.message = message;
    }

    public String print() {
        return message;
    }
}
