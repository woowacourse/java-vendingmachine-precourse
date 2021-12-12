package vendingmachine.model.enums;

import java.util.Arrays;
import java.util.List;
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

    public int getValue() {
        return amount;
    }

    public static List<Integer> getValuesList() {
        return Arrays.asList(Coin.values())
            .stream()
            .map(coin -> coin.getValue())
            .collect(Collectors.toList());
    }
}
