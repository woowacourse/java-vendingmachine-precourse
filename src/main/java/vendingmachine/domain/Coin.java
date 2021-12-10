package vendingmachine.domain;

import static vendingmachine.NumberConstant.*;

import java.util.Arrays;
import java.util.List;

import vendingmachine.util.Random;

public enum Coin {
    COIN_500(FIVE_HUNDRED),
    COIN_100(HUNDRED),
    COIN_50(FIFTY),
    COIN_10(TEN);

    private final int amount;

    public static final List<Integer> amountList = Arrays.asList(FIVE_HUNDRED, HUNDRED, FIFTY, TEN);

    Coin(final int amount) {
        this.amount = amount;
    }

    public static Coin getRandom() {
        return getByAmount(Random.generateAmount());
    }

    public static Coin getByAmount(int amount) {
        return Arrays.stream(Coin.values())
            .filter(coin -> coin.isEqual(amount))
            .findAny()
            .get();
    }

    public boolean isEqual(int amount) {
        if (this.amount == amount) {
            return true;
        }
        return false;
    }

    public boolean isSmall(int amount) {
        if (this.amount <= amount) {
            return true;
        }
        return false;
    }

    public int subtractAmount(int amount) {
        if (amount == ZERO) {
            return ZERO;
        }
        return amount - this.amount;
    }

    public int getChangeCount(int amount) {
        if (amount < this.amount) {
            return ZERO;
        }

        return amount / this.amount;
    }

    public int multiplyCount(int count) {
        return this.amount * count;
    }
}
