package vendingmachine.domain;

import static vendingmachine.constants.FormatConstants.WON;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        return this.amount;
    }

    public String getAmountFormat() {
        return this.amount + WON;
    }

    public static Coin getCoinByAmount(int amount) {
        for (Coin coin : Coin.values()) {
            if (coin.amount != amount) continue;
            return coin;
        }
        throw new IllegalArgumentException();
    }

    public static List<Coin> getCoinsDesc() {
        return Stream.of(Coin.values()).collect(Collectors.toList());
    }

    public static List<Integer> getCoinsAmountDesc() {
        return Stream.of(Coin.values())
                     .map(coin -> coin.amount)
                     .collect(Collectors.toList());
    }
}
