package vendingmachine;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;

    public static List<Integer> coinAmountList = Arrays.stream(Coin.values())
                                                        .map(Coin::getAmount)
                                                        .collect(Collectors.toList());

    public static final Map<Integer, String> AmountMap = Collections.unmodifiableMap(
            Stream.of(values()).collect(Collectors.toMap(Coin::getAmount, Coin::name))
    );

    public static Coin of(final int amount) {
        if (!coinAmountList.contains(amount)) {
            throw new NoSuchElementException(ErrorMessage.NO_COIN_MATCH.getCompleteMessage());
        }

        return Coin.valueOf(AmountMap.get(amount));
    }

    Coin(final int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}
