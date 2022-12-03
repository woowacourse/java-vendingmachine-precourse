package vendingmachine.utils;

public enum Message {
    INPUT_INIT("자판기가 보유하고 있는 금액을 입력해 주세요."),
    OUTPUT_INIT_CHANGE("자판기가 보유한 동전"),
    INPUT_PRODUCT("상품명과 가격, 수량을 입력해 주세요."),
    INPUT_CASH("투입 금액을 입력해 주세요."),
    OUTPUT_CASH("투입 금액:"),
    INPUT_PURCHASE("구매할 상품명을 입력해 주세요."),
    OUTPUT_RESULT_CHANGE("잔돈\n" +
            "100원 - 4개\n" +
            "50원 - 1개");


    private final String message;

    Message(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
