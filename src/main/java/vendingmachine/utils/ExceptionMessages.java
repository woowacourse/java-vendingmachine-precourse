package vendingmachine.utils;

public enum ExceptionMessages {

    ERROR_MESSAGE_INPUT_MONEY("[ERROR] 자판기 보유 금액은 숫자만 입력 가능합니다.");

    private final String errorMessage;

    ExceptionMessages(final String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
