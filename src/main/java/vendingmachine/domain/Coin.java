package vendingmachine.domain;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    public static Coin pickRandom() {
        int randomIndex = Randoms.pickNumberInList(
            IntStream.range(0, values().length)
                .boxed()
                .collect(Collectors.toList())
        );
        return Coin.values()[randomIndex];
    }

    @Override
    public String toString() {
        return String.valueOf(amount);
    }

    public Money toMoney() {
        return new Money(amount);
    }
}
