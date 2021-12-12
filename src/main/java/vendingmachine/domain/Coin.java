package vendingmachine.domain;

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

    public int countCoin(int totalAmount) {
        int count = 0;
        while (totalAmount >= amount) {
            count++;
            totalAmount -= amount;
        }
        return count;
    }

    public int countReducedAmount(int totalAmount) {
        while (totalAmount >= amount) {
            totalAmount -= amount;
        }
        return totalAmount;
    }

    public static Stream<Coin> stream() {
        return Stream.of(Coin.values());
    }
}
