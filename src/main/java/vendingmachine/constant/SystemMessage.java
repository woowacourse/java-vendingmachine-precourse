package vendingmachine.constant;

public enum SystemMessage {
    SET_MACHINE_MONEY_MESSAGE("자판기가 보유하고 있는 금액을 입력해 주세요."),
    COIN_STATUS_MESSAGE("자판가가 보유한 동전"),
    SET_MERCHANDISE_MESSAGE("상품명과 가격, 수량을 입력해 주세요."),
    SET_INPUT_MONEY_MESSAGE("투입 금액을 입력해주세요.");

    private String message;

    SystemMessage(String message) {
        this.message = message;
    }

    public String print() {
        return message;
    }
}
