package vendingmachine;

public enum ErrorMessage {
    CONTAINS_BLANK_ERROR_MESSAGE("[ERROR] 빈 칸은 입력하실 수 없습니다."),
    AMOUNT_FORMAT_ERROR_MESSAGE("[ERROR] 금액은 숫자여야 합니다."),
    AMOUNT_UNIT_ERROR_MESSAGE("[ERROR] 금액은 10원 단위로 나누어 떨어져야 합니다."),
    AMOUNT_NEGATIVE_ERROR_MESSAGE("[ERROR] 금액은 음수가 될 수 없습니다."),
    PRODUCT_DUPLICATE_ERROR_MESSAGE("[ERROR] 중복된 상품명을 사용하실 수 없습니다."),
    PRODUCT_COUNT_ERROR_MESSAGE("[ERROR] 수량은 1개 이상 입력하셔야합니다."),
    PRODUCT_PRICE_ERROR_MESSAGE("[ERROR] 가격은 100원 이상 입력하셔야합니다."),
    PRODUCT_SOLD_OUT_ERROR_MESSAGE("[ERROR] 해당 상품은 현재 없는 상품입니다."),
    DUPLICATE_SEPARATOR_ERROR_MESSAGE("[ERROR] 구분자는 한 번씩만 사용하실 수 있습니다.");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
