package domain.constant;

import util.EnumUtil;

public enum ProductConstant implements EnumUtil<String, String> {
    SPLIT_DELIMITER_COMMA(",");

    private final String value;

    ProductConstant(final String value) {
        this.value = value;
    }

    @Override
    public String getKey() {
        return name();
    }

    @Override
    public String getValue() {
        return value;
    }
}
