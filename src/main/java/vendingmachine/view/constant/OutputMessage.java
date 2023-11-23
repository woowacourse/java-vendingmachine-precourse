package vendingmachine.view.constant;

public enum OutputMessage {
    RESPONSE_VM_COIN("자판기가 보유한 동전"),
    RESPONSE_COIN("<할인 전 총주문 금액>"),
    RESPONSE_CHARGE("잔돈");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
