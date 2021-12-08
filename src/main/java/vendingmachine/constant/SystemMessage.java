package vendingmachine.constant;

public enum SystemMessage {
    PRINT_SET_MACHINE_MONEY_MESSAGE("자판기가 보유하고 있는 금액을 입력해 주세요.");

    private String message;

    SystemMessage(String message) {
        this.message = message;
    }

    public String print() {
        return message;
    }
}
