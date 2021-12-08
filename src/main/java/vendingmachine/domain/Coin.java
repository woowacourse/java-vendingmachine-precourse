package vendingmachine.domain;

import static vendingmachine.NumberConstant.*;

public enum Coin {
    COIN_500(FIVE_HUNDRED),
    COIN_100(HUNDRED),
    COIN_50(FIFTY),
    COIN_10(TEN);

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    // 추가 기능 구현
}
