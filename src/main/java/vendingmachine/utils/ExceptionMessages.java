package vendingmachine.utils;

public enum ExceptionMessages {

    ERROR_MESSAGE_INPUT_MONEY_NUMBER("[ERROR] 자판기 보유 금액은 숫자만 입력 가능합니다."),
    ERROR_MESSAGE_INPUT_MONEY_UNIT("[ERROR] 자판기 보유 금액은 10의 배수만 입력 가능합니다."),
    ERROR_MESSAGE_PRODUCT_INFORMATION_FORMAT("[ERROR] 상품명은 한글, 가격과 수량은 0이상의 숫자만 입력 가능합니다.\n(상품명, 가격, 수량은 쉼표(,)로, 개별 상품은 대괄호([])로 묶어 세미콜론(;)으로 구분해야 합니다.)"),
    ERROR_MESSAGE_PRODUCT_PRICE_FORMAT("[ERROR] 상품가격은 100원부터 시작하며, 10원으로 나누어 떨어져야 합니다."),
    ERROR_MESSAGE_PRODUCT_PRICE_NUMBER("[ERROR] 상품가격은 숫자만 입력 가능합니다."),
    ERROR_MESSAGE_PRODUCT_NAME_KOREAN("[ERROR] 상품이름은 한글로 입력되어야 합니다."),
    ERROR_MESSAGE_INPUT_PURCHASING_COST("[ERROR] 투입 금액은 숫자만 입력 가능합니다.");

    private final String errorMessage;

    ExceptionMessages(final String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
