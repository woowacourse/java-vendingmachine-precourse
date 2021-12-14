package vendingmachine.domain;

import java.util.Map;

public class Changes {

    private static final String ERR_INVALID_COUNT = "동전의 개수는 0 이상이어야합니다.";
    private static final int NO_COIN = 0;
    private final Map<Coin, Integer> changes;

    public Changes(Map<Coin, Integer> changes) {
        validatePositiveNumber(changes);
        this.changes = changes;
    }

    public int getCoinCount(Coin coin) {
        return changes.getOrDefault(coin, NO_COIN);
    }

    private void validatePositiveNumber(Map<Coin, Integer> changes) {
        if (!changes.values().stream().allMatch(c -> c > NO_COIN)) {
            throw new IllegalArgumentException(ERR_INVALID_COUNT);
        }
    }
}
