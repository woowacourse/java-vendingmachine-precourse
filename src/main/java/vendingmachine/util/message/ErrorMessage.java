package vendingmachine.util.message;

import static vendingmachine.util.NumberConsts.MIN_PRICE;
import static vendingmachine.util.NumberConsts.MIN_UNIT;

public enum ErrorMessage {
    ERROR_MESSAGE("[ERROR] "),
    INVALID_PRICE(String.format("%d원 이상이어야 합니다.", MIN_PRICE)),
    INVALID_UNIT(String.format("%d원으로 나누어떨어져야 합니다.", MIN_UNIT)),
    INVALID_FORMAT("형식에 맞지 않습니다."),
    NOT_NUMBER("형식에 맞지 않습니다."),
    IS_NEGATIVE("음수를 입력할 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String fullMessage() {
        return ERROR_MESSAGE.message + message;
    }
}
