package vendingmachine;

public enum ErrorMessage {
    NOT_NUMBER(new IllegalArgumentException("[ERROR] 금액은 숫자여야 합니다.")),
    NOT_DIVISIBLE_VALUE(new IllegalArgumentException("[ERROR] 금액은 10원으로 나누어져야 합니다.")),
    NOT_NATURAL_NUMBER(new IllegalArgumentException("[ERROR] 금액은 0원을 넘어야합니다.")),
    NOT_FOUND_PRODUCT(new IllegalArgumentException("[ERROR] 존재하지 않는 상품입니다.")),
    IMPOSSIBLE_BUY_PRODUCT(new IllegalArgumentException("[ERROR] 해당 상품이 모두 소진되었습니다.")),
    INVALID_BRACKETS(new IllegalArgumentException("[ERROR] 개별 상품은 대괄호 '[]'로 묶어 입력하세요.")),
    INVALID_DELIMITER(new IllegalArgumentException("[ERROR] 상품명, 가격, 수량은 쉼표','로 구분해주세요.")),
    INVALID_PRODUCT_NAME(new IllegalArgumentException("[ERROR] 상품의 이름을 입력해주세요.")),
    INVALID_NOT_ALLOW_NAME(new IllegalArgumentException("[ERROR] 이름은 쉼표가 될 수 없습니다."))
    ;

    private final RuntimeException exception;

    ErrorMessage(RuntimeException exception) {
        this.exception = exception;
    }

    public RuntimeException getException() {
        return exception;
    }
}
