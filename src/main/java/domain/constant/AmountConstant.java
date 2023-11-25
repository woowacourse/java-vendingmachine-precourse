package domain.constant;

import util.EnumUtil;

public enum AmountConstant implements EnumUtil<String, Integer> {
    COIN_TEN(10),
    ZERO(0);

    private final int number;

    AmountConstant(final int number){
        this.number = number;
    }

    @Override
    public String getKey() {
        return name();
    }

    @Override
    public Integer getValue() {
        return number;
    }
}
