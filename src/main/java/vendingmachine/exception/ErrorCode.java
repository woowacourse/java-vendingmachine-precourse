package vendingmachine.exception;

import java.util.function.BooleanSupplier;

public enum ErrorCode {
    INVALID_COIN_INPUT("금액은 숫자여야 합니다. 다시 입력해 주세요."),
    INVALID_INPUT("유효하지 않은 입력입니다. 다시 입력해 주세요."),
    INVALID_PRODUCT_FORMAT("유효하지 않은 상품 형식입니다. 다시 입력해 주세요."),
    INVALID_PRODUCT_NAME("유효하지 않은 상품명입니다. 다시 입력해 주세요."),
    INVALID_PRODUCT_PRICE("유효하지 않은 상품 금액입니다. 다시 입력해 주세요."),
    INVALID_PRODUCT_QUANTITY("유효하지 않은 상품 수량입니다. 다시 입력해 주세요."),
    INVALID_ORDER("유효하지 않은 주문입니다. 다시 입력해 주세요."),
    INVALID_ORDER_PRODUCT("존재하지 않는 상품입니다. 다시 입력해 주세요."),
    INVALID_ORDER_QUANTITY("품절된 상품입니다. 다시 입력해 주세요."),
    INVALID_ORDER_MONEY("잔액이 부족합니다. 다른 상품을 입력해 주세요.");

    public static final String ERROR_PREFIX = "[ERROR] ";
    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public void validate(BooleanSupplier condition) {
        if (isSameCondition(condition)) {
            throw BusinessException.from(this);
        }
    }

    private boolean isSameCondition(BooleanSupplier condition) {
        return condition.getAsBoolean();
    }

    public String getMessage() {
        return ERROR_PREFIX + message;
    }
}
