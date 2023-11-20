package utils;

public enum ErrorMessages {

    VALIDATE_BLANK("[ERROR] 금액은 공백일 수 없습니다. 다시 입력해 주세요."),
    ;

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getErrorMessage() {
        return message;
    }
}
