package vendingmachine.model;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public int inputCoinCountRandomly(List<Integer> coins) {
        return Randoms.pickNumberInList(coins);
    }

}
