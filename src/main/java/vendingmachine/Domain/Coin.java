package vendingmachine.Domain;

import vendingmachine.Constant.OutputConstant;

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

    private int getAmount() {
        return amount;
    }

    public static List<Integer> getAmountList() {
        return Stream.of(values())
                .map(c -> c.amount)
                .collect(Collectors.toList());
    }

    public static Coin getCoinByAmount(int amount) {
        return Stream.of(Coin.values())
                .filter(c -> c.getAmount() == amount)
                .findFirst()
                .orElse(null);
    }

    public String printAmount() {
        return getAmount() + OutputConstant.COIN_AMOUNT;
    }

}
