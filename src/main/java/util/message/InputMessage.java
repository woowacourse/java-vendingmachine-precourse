package util.message;

import util.EnumUtil;

public enum InputMessage implements EnumUtil<String, String> {

    INPUT_POSSESSION_AMOUNT_MESSAGE("자판기가 보유하고 있는 금액을 입력해 주세요.");

    private final String message;

    InputMessage(final String message) {
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
