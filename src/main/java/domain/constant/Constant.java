package domain.constant;

import util.EnumUtil;

public enum Constant implements EnumUtil<String, Integer> {
    COIN_TEN(10),
    COIN_HUNDRED(100),
    ZERO(0),
    ONE_THOUSANE(1000);

    private final int number;

    Constant(final int number){
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
