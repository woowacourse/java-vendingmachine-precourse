package domain.constant;

import util.EnumUtil;

public enum ProductsConstant implements EnumUtil<String, String> {
    SPLIT_DELIMITER_SEMICOLON(";"),
    BLANK("");

    private final String value;

    ProductsConstant(final String value) {
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
