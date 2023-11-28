package util.message;

import util.EnumUtil;

public enum OutputMessage implements EnumUtil<String, String> {
    VENDING_MACHINE_STATUS("\n자판기가 보유한 동전"),
    PAYMENT_AMOUNT("\n투입 금액: %d원"),
    COIN_OUTPUT_FORMAT("%s - %s개"),
    CHANGE_MESSAGE("잔돈"),
    NO_CHANGE_MESSAGE("반환할 잔돈이 없습니다."),
    COIN_500("500원"),
    COIN_100("100원"),
    COIN_50("50원"),
    COIN_10("10원");


    private final String message;

    OutputMessage(final String message) {
        this.message = message;
    }

    @Override
    public String getKey() {
        return name();
    }

    @Override
    public String getValue() {
        return message;
    }
}
