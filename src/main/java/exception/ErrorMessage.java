package exception;

public enum ErrorMessage {

    NON_PRESENT_PRODUCT_ERROR_MESSAGE("[ERROR] : 자판기에 존재하지 않는 상품입니다."),
    NON_PRICE_MINIMUM_ERROR_MESSAGE("[ERROR] : 가격은 100원 이상이어야 합니다."),
    NON_FORMAT_ERROR_MESSAGE("[ERROR] : 형식이 맞지 않습니다."),
    NON_UNIT_ERROR_MESSAGE("[ERROR] : 10원 단위여야 합니다."),
    NON_NUMBER_ERROR_MESSAGE("[ERROR] : 숫자여야 합니다.");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
