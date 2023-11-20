package utils;

public enum ErrorMessages {

    VALIDATE_BLANK("[ERROR] 금액은 공백일 수 없습니다."),
    VALIDATE_MINIMUM_RANGE("[ERROR] 금액은 100원 보다 적을 수 없습니다."),
    VALIDATE_DIVIDE_BY_TEN("[ERROR] 금액은 10원 단위여야 합니다."),
    VALIDATE_NUMERIC("[ERROR] 금액에 숫자 이외의 값이 들어올 수 없습니다."),
    ;

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getErrorMessage() {
        return message;
    }
}
