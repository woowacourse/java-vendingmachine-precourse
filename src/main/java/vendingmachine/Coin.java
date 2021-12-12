package vendingmachine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.stream.Collectors;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    public static int getRandomAmount() {
        return Randoms.pickNumberInList(
            Arrays.stream(Coin.values())
                .map(Coin::getAmount)
                .collect(Collectors.toList())
        );
    }

    public static Coin findByAmount(int amount) {
        return Arrays.stream(Coin.values())
            .filter(coin -> coin.amount == amount)
            .findAny()
            .get();
    }

    public int getAmount() {
        return this.amount;
    }
}
