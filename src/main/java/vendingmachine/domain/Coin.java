package vendingmachine.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.concurrent.atomic.AtomicLong;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    public static EnumMap<Coin, Long> generateMinimumCoins(long totalAmount) {
        EnumMap<Coin, Long> coins = new EnumMap<>(Coin.class);
        AtomicLong remainingAmount = new AtomicLong(totalAmount);

        Arrays.stream(Coin.values()).forEach(coin -> {
            long coinCount = remainingAmount.get() / coin.getAmount();
            remainingAmount.addAndGet(-coinCount * coin.getAmount());
            coins.put(coin, coinCount);
        });

        return coins;
    }

    public int getAmount() {
        return amount;
    }
}