package vendingmachine.domain.coin;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import vendingmachine.exception.VendingMachineException;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private static final Map<Integer, Coin> coins = new HashMap<>();

    static {
        Arrays.stream(values())
                .forEach(coin -> coins.put(coin.amount, coin));
    }

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    // 추가 기능 구현
    public static Coin from(int amount) {
        return Optional.ofNullable(coins.get(amount))
                .orElseThrow(VendingMachineException.INVALID_COIN_PRICE::makeException);
    }

    public int getAmount() {
        return amount;
    }
}
