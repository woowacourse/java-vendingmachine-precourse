package util.message;

import util.EnumUtil;

public enum OutputMessage implements EnumUtil<String, String> {

    WON("원"),
    COUNT("개"),
    HYPHEN(" - "),
    VENDING_MACHINE_STATUS("자판기가 보유한 동전\n");


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
