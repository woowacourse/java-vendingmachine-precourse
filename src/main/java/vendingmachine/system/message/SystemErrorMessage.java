package vendingmachine.system.message;

public enum SystemErrorMessage {
    ERROR_INPUT_HOLDING_MONEY_MESSAGE("[ERROR] 금액은 100 이상 그리고 1억 이하의 숫자이여야 하며 10으로 나누어 떨어져야 합니다."),
    ERROR_PRODUCT_PRICE_STOCK_MESSAGE("[ERROR] [{상품명},{가격},{수량}] 형식으로 입력하셔야 하며 공백이 포함되선 안됩니다. 상품 구분자는 ';' 입니다."),
    ERROR_USER_INSERT_MONEY_MESSAGE("[ERROR] 투입 금액은 1억 이하의 숫자이여야 하며 10으로 나누어 떨어져야 합니다."),
    ERROR_PRODUCT_NAME_TO_BUY_MESSAGE("[ERROR] 상품명은 한글로 입력해야 합니다. 또는 존재하지 않습니다.");

    private final String message;

    SystemErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
