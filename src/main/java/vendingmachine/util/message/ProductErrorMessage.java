package vendingmachine.util.message;

public enum ProductErrorMessage {
    ERROR_MESSAGE("[ERROR] "),
    INVALID_NAME("같은 이름의 상품은 입력할 수 없습니다."),
    NOT_FOR_SALE("판매하지 않는 상품입니다."),
    INSUFFICIENT_BALANCE("잔액이 부족합니다."),
    OUT_OF_STOCK("상품이 품절되었습니다.");

    private final String message;

    ProductErrorMessage(String message) {
        this.message = message;
    }

    public String fullMessage() {
        return ERROR_MESSAGE.message + message;
    }
}
