package vendingmachine;

public enum ErrorMessage {
    ERROR_VENDING_MACHINE_INPUT_MONEY_ERROR("[ERROR] 10원 단위의 숫자를 입력해야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
