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
    private static final String ERR_INVALID_COIN = "존재하지 않는 동전입니다.";

    Coin(final int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public static Coin getCoin(int amount) {
        return Arrays.stream(Coin.values())
            .filter(c -> c.amount == amount)
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException(ERR_INVALID_COIN));

    }

    public static Coin getRandomCoinBelowAmount(int maximum) {
        return getCoin(Randoms.pickNumberInList(
            Arrays.stream(Coin.values())
                .filter(coin -> coin.amount <= maximum)
                .map(coin -> coin.amount)
                .collect(Collectors.toList())
        ));
    }
}
