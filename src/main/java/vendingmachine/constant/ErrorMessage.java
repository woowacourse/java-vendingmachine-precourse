package vendingmachine.constant;

public enum ErrorMessage {
    NULL_ERROR_MESSAGE("[ERROR] 입력값이 비어있습니다."),
    BIGGER_THAN_MIN_COIN_UNIT("[ERROR] 입력값은 10으로 나누어 떨어져야 합니다."),
    NOT_DIGIT_MESSAGE("[ERROR] 입력값은 숫자로만 이루어져야 합니다."),
    NOT_CORRECT_BRACKET("[ERROR] 상품 정보는 대괄호로 묶어주어야 합니다."),
    NULL_IN_LIST("[ERROR] 상품의 정보 중 누락된 값이 있습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String print() {
        return message;
    }
}
