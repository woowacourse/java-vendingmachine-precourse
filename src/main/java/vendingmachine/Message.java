package vendingmachine;

public enum Message {
    REQUEST_VENDING_MACHINE_HOLD_MONEY_INPUT_MESSAGE("자판기가 보유하고 있는 금액을 입력해 주세요.\n"),
    RESULT_VENDING_MACHINE_HOLD_COINS_MESSAGE("\n자판기가 보유한 동전\n"
            + "%s원 - %s개\n"
            + "%s원 - %s개\n"
            + "%s원 - %s개\n"
            + "%s원 - %s개\n\n"),
    REQUEST_GOODS_INPUT_MESSAGE("상품명과 가격, 수량을 입력해 주세요.\n"),
    REQUEST_MONEY_INPUT_MESSAGE("\n투입 금액을 입력해 주세요.\n"),
    REQUEST_BUYING_GOODS_INPUT_MESSAGE("\n구매할 상품명을 입력해 주세요.\n"),
    BALANCE_MESSAGE("\n투입 금액: %s원\n"),
    CHANGES_MESSAGE("잔돈\n"),
    CHANGES_AMOUNT("%s원 - %s개\n");


    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
