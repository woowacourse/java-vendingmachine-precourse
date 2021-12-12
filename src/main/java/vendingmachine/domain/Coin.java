package vendingmachine.domain;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private static final String WON_AND_HYPHEN_SYMBOL = "원 - ";

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public static List<Coin> getCoinListDecreasingOrder() {
        return Arrays.asList(values());
    }

    public static Coin pickRandomCoin(final int maximum) {
        Coin randomCoin;
        do {
            int randomIndex = Randoms.pickNumberInRange(0, 3);
            randomCoin = getCoinListDecreasingOrder().get(randomIndex);
        } while (randomCoin.getAmount() > maximum);
        return randomCoin;
    }

    public String toString() {
        return amount + WON_AND_HYPHEN_SYMBOL;
    }
}
