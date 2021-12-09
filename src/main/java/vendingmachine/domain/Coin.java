package vendingmachine.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;
    public static final List<Integer> COIN_LIST = getCoinStream().map(c-> c.getValue()).collect(Collectors.toList());

    Coin(final int amount) {
        this.amount = amount;
    }

    public static Stream<Coin> getCoinStream(){
        return Stream.of(Coin.values());
    }

    public int getValue(){
        return amount;
    }
}
