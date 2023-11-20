package vendingmachine;

public enum ErrorMessage {
    ERROR_VENDING_MACHINE_INPUT_MONEY("[ERROR] 10원 단위의 숫자를 입력해야 합니다."),
    ERROR_INPUT_GOODS("[ERROR] 잘못된 상품 입력입니다."),
    ERROR_GOODS_NOT_UNIQUE("[ERROR] 상품 이름이 중복됩니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
