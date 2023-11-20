package vendingmachine;

public enum ErrorMessage {
    //TODO: 리팩토링 ; INPUT이 맨 뒤로
    ERROR_VENDING_MACHINE_INPUT_MONEY("[ERROR] 10원 단위의 숫자를 입력해야 합니다."),
    ERROR_INPUT_GOODS("[ERROR] 잘못된 상품 입력입니다."),
    ERROR_GOODS_NOT_UNIQUE("[ERROR] 상품 이름이 중복됩니다."),
    ERROR_CUSTOMER_MONEY_INPUT("[ERROR] 숫자만 입력할 수 있습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
