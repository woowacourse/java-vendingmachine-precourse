package vendingmachine;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.toList;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }
    // 추가 기능 구현

    public int getAmount() {
        return amount;
    }

    public
}
