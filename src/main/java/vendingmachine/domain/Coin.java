package vendingmachine.domain;

import java.util.ArrayList;
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

    public static List<Integer> getCoinAmountList() {
        List<Integer> coinAmountList = new ArrayList<>();
        getCoinListDecreasingOrder().forEach(coin -> coinAmountList.add(coin.getAmount()));
        return coinAmountList;
    }

    public static Coin getCoin(final int amountOfUnit) {
        return getCoinListDecreasingOrder().stream()
            .filter(coin -> coin.getAmount() == amountOfUnit)
            .findFirst()
            .get();
    }

    public String toString() {
        return amount + WON_AND_HYPHEN_SYMBOL;
    }
}
