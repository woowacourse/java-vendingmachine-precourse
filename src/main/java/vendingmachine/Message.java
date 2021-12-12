package vendingmachine;

public enum Message {
    INPUT_VENDING_MACHINE_HOLDING_MONEY("자판기가 보유하고 있는 금액을 입력해 주세요."),
    VENDING_MACHINE_INFORMATION("자판기가 보유한 동전");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
