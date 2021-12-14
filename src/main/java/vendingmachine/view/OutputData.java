package vendingmachine.view;

public enum OutputData {
    INPUT_MONEY_LEFT("투입 금액:"),
    CHANGE("잔돈"),
    MACHINES_COINS("자판기가 보유한 동전"),
    COIN_UNIT("원"),
    COIN_COUNT("개"),
    COIN_DIVIDER("-"),
    ERROR("[ERROR]");

    private final String data;

    OutputData(final String data) {
        this.data = data;
    }

    public String toString() {
        return data;
    }
}
