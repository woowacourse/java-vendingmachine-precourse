package vendingmachine.exception;

public enum ErrorMessage {
    CAPTION("[ERROR] "),
    NOT_NUMERIC_AMOUNT("금액은 숫자여야 합니다."),
    INVALID_VENDING_MACHINE_AMOUNT("금액은 10으로 나눠떨어져야 합니다."),
    INVALID_ITEMS_FORMAT("유효하지 않은 상품 입력 형식 입니다."),
    INVALID_ITEM_DETAIL("유효하지 않은 상품 입력 값 입니다."),
    INVALID_ITEM_PRICE("상품 가격은 100 이상 이어야 하고, 10 으로 나눠떨어지는 값이어야 합니다."),
    DUPLICATE_ITEM_NAMES("중복된 상품 이름 입니다."),
    INVALID_ORDER_ITEM_NAME("유효하지 않은 상품명 입니다."),
    CANNOT_BUY_ORDER_ITEM("재고가 없거나 금액이 부족하여 해당 상품은 구매 불가합니다."),
    INVALID_ORDER_ITEM("구매 가능한 아이템이 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return CAPTION.message + message;
    }
}
