package vendingmachine.util;

public enum Error {
    CHANGE_INPUT_EXCEPTION("잔돈 입력이 잘못됐습니다.");

    private final String message;
    private final String prefix = "[ERROR] ";

    Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return prefix + message;
    }
}
