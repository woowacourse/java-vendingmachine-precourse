package vendingmachine.model.change.vo;

import java.util.Arrays;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private static final String COIN_NOT_FOUND_EXCEPTION_MESSAGE = "동전은 500, 100, 50, 10원 밖에 없습니다.";
    private final int amount;

    public static Coin of(final int amount) {
        return Arrays.stream(values())
                .filter(coin -> coin.getAmount() == amount)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(COIN_NOT_FOUND_EXCEPTION_MESSAGE));
    }

    Coin(final int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return this.amount;
    }

    public int getNumberOfPossibleGeneration(final int money) {
        return money / amount;
    }
}
