package vendingmachine.util;

public enum Message {
    CHANGE_MESSAGE("잔돈\n"),
    CHANGE_AMOUNT_PREFIX("원 - "),
    CHANGE_AMOUNT_SUFFIX("개\n"),
    MACHINE_PREFIX("투입 금액: "),
    MACHINE_SUFFIX("구매할 상품을 입력해 주세요."),
    MACHINE_CHANGE("자판기가 보유하고 있는 금액을 입력해 주세요.\n"),
    MACHINE_HAS_CHANGE("자판기가 보유한 동전\n");

    private final String message;

    Message(String message) {
        this.message = message;
    }
    public String getMessage(){
        return message;
    }
}
