package vendingmachine.util;

public enum ErrorMessage {
    ERROR_CANNOT_CONTAIN_SPACE("[ERROR] 상품 이름에는 공백 문자를 포함할 수 없습니다."),
    ERROR_CANNOT_DUPLICATE("[ERROR] 상품 이름은 중복될 수 없습니다."),
    ERROR_CANNOT_CONTAIN_COMMA_LAST_STRING("[ERROR] 개별 상품 정보는 쉼표로 끝날 수 없습니다."),

    ERROR_NOT_NUMBER("[ERROR] 금액은 숫자여야 합니다."),
    ERROR_OUT_OF_RANGE_AMOUNT("[ERROR] 금액은 10원 이상이어야 합니다."),
    ERROR_CANNOT_DIVIDE_BY_TEN("[ERROR] 금액은 10원 단위여야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
