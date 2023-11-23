package vendingmachine.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Coin {

    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private static final String NOT_FOUND_COIN_EXCEPTION = "%d원짜리 동전은 존재하지 않습니다.";

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    public static Coin from(int amount) {
        return Arrays.stream(values())
                .filter(coin -> coin.amount == amount)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format(NOT_FOUND_COIN_EXCEPTION, amount)));
    }

    public static List<Integer> findAmountLessThen(int amount) {
        return Arrays.stream(values())
                .filter(coin -> coin.amount <= amount)
                .map(coin -> coin.amount)
                .collect(Collectors.toList());
    }

    public int getAmount() {
        return amount;
    }
}
