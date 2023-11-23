package vendingmachine.view.constants;

public enum MachineMessage {
    INPUT_MACHINE_MONEY("자판기가 보유하고 있는 금액을 입력해 주세요"),
    INPUT_MACHINE_PRODUCT("\n상품명과 가격, 수량을 입력해 주세요."),
    MACHINE_CHANGE("\n자판기가 보유한 동전"),
    COIN_FORMAT("%d원 - %d개"),
    USER_AMOUNT("\n투입 금액: %d원"),
    CHANGE("잔돈"),
    NEWLINE("\n");


    private final String message;

    MachineMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
