package vendingmachine.domain;

import vendingmachine.util.PublicConst;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    // 추가 기능 구현
    public int getAmount() {
        return amount;
    }

    public static Coin getCoin(int coinUnit) {
        if(coinUnit == COIN_500.getAmount())
            return COIN_500;
        if(coinUnit == COIN_100.getAmount())
            return COIN_100;
        if(coinUnit == COIN_50.getAmount())
            return COIN_50;
        if(coinUnit == COIN_10.getAmount())
            return COIN_10;

        return null;
    }

    public void printCoinAndCount(int count) {
        String str = getAmount()
            + PublicConst.MONETARY_UNIT
            + PublicConst.COIN_DELIMITER
            + count
            + PublicConst.COUNT_LITERAL;
        System.out.println(str);
    }
}
