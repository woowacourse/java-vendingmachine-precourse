package vendingmachine.model;

import java.util.Arrays;
import java.util.Comparator;
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

    public int getAmount() {
        return this.amount;
    }

    public static List<Integer> getOrderedCoinAmounts() {
        return Arrays.stream(values())
            .map(Coin::getAmount)
            .sorted(Comparator.reverseOrder())
            .collect(Collectors.toList());
    }

    public static Coin parse(int amount){
        return Arrays.stream(values())
            .filter(coin -> amount == coin.amount)
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("[ERROR] 존재하지 않는 코인입니다."));
    }
}
