package vendingmachine;

public enum ErrorMessage {
    // 자판기 보유 금액
    NOT_PRICE(new IllegalArgumentException("[ERROR] 금액은 숫자여야합니다.")),
    NOT_DIVISIBLE_VALUE(new IllegalArgumentException("[ERROR] 금액은 10원으로 나누어져야 합니다.")),
    NOT_NATURAL_NUMBER(new IllegalArgumentException("[ERROR] 금액은 0원을 넘어야합니다.")),

    // 상품 등록
    INVALID_SEMICOLON(new IllegalArgumentException("[ERROR] 상품 단위를 세미콜론 ';'으로 분리해주세요.")),
    INVALID_BRACKETS(new IllegalArgumentException("[ERROR] 개별 상품은 대괄호 '[]'로 묶어 입력하세요.")),
    INVALID_DELIMITER(new IllegalArgumentException("[ERROR] 상품명, 가격, 수량은 쉼표','로 구분해주세요.")),
    INVALID_PRODUCT_NAME(new IllegalArgumentException("[ERROR] 상품의 이름을 입력해주세요.")),
    INVALID_NOT_ALLOW_NAME(new IllegalArgumentException("[ERROR] 이름은 쉼표가 될 수 없습니다.")),
    NOT_NUMBER(new IllegalArgumentException("[ERROR] 상품의 가격 또는 수량은 숫자로 입력해주세요.")),
    MIN_PRICE(new IllegalArgumentException("[ERROR] 상품의 최소 금액은 100원입니다.")),
    NOT_DIVISIBLE(new IllegalArgumentException("[ERROR] 상품은 10원으로 나누어져야 합니다.")),
    INVALID_QUANTITY_(new IllegalArgumentException("[ERROR] 상품의 수량은 1개를 넘어야 합니다.")),

    // 상품 구매
    NOT_FOUND_PRODUCT(new IllegalArgumentException("[ERROR] 존재하지 않는 상품입니다.")),
    IMPOSSIBLE_BUY_PRODUCT(new IllegalArgumentException("[ERROR] 해당 상품이 모두 소진되었습니다."));

    private final RuntimeException exception;

    ErrorMessage(RuntimeException exception) {
        this.exception = exception;
    }

    public RuntimeException getException() {
        return exception;
    }
}
