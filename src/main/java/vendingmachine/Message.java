package vendingmachine;

public enum Message {
    REQUEST_VENDING_MACHINE_HOLD_MONEY_MESSAGE("자판기가 보유하고 있는 금액을 입력해 주세요.\n"),
    RESULT_VENDING_MACHINE_HOLD_COINS_MESSAGE("\n자판기가 보유한 동전\n"
            + "%s원 - %s개\n"
            + "%s원 - %s개\n"
            + "%s원 - %s개\n"
            + "%s원 - %s개\n\n"),
    REQUEST_GOODS_INPUT_MESSAGE("상품명과 가격, 수량을 입력해 주세요.\n");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
