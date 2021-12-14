package vendingmachine.utils;

public enum ExceptionMessages {

    ERROR_MESSAGE_INPUT_MONEY_NUMBER("[ERROR] 금액은 숫자만 입력 가능합니다."),
    ERROR_MESSAGE_COUNT_LESS_THAN_ZERO("[ERROR] 상품 수량은 0보다 커야합니다."),
    ERROR_MESSAGE_INPUT_MONEY_LESS_THAN_ZERO("[ERROR] 투입 금액이 0보다 커야합니다."),
    ERROR_MESSAGE_PRODUCT_NAME_DUPLICATE("[ERROR] 상품 목록이 중복되었습니다."),
    ERROR_MESSAGE_INPUT_MACHINE_MONEY_CONDITION("[ERROR] 자판기 보유 금액은 10의 배수만 입력 가능합니다."),
    ERROR_MESSAGE_PRODUCT_INFORMATION_CONDITION("[ERROR] 상품명은 한글, 가격과 수량은 0이상의 숫자만 입력 가능합니다.\n(상품명, 가격, 수량은 쉼표(,)로, 개별 상품은 대괄호([])로 묶어 세미콜론(;)으로 구분해야 합니다.)"),
    ERROR_MESSAGE_PRODUCT_PRICE_CONDITION("[ERROR] 상품가격은 100원부터 시작하며, 10원으로 나누어 떨어져야 합니다."),
    ERROR_MESSAGE_PURCHASING_PRODUCT_NAME_CONDITION("[ERROR] 구입할 상품은 상품 목록에 있는 값만 입력 가능합니다."),
    ERROR_MESSAGE_PURCHASING_PRODUCT_SOLD_OUT("[ERROR] 구입할 상품이 품절되었습니다."),
    ERROR_MESSAGE_SHORT_MONEY("[ERROR] 돈이 부족하여 해당 상품을 구입할 수 없습니다."),
    ERROR_MESSAGE_PRODUCT_NAME_KOREAN("[ERROR] 상품이름은 한글로 입력되어야 합니다.");

    private final String errorMessage;

    ExceptionMessages(final String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
