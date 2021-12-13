package vendingmachine.model.coin;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.util.Message;

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

    public static Coin of(int amount) {
        return Arrays.stream(Coin.values())
            .filter(coin -> coin.getAmount() == amount)
            .findFirst()
            .orElseThrow(() -> new NoSuchElementException(Message.COIN_NO_SUCH_ERROR));
    }

    public static List<Integer> toList() {
        return Arrays.stream(Coin.values()).map(Coin::getAmount)
            .collect(Collectors.toList());
    }

    public static int createRandomCoin() {
        return Randoms.pickNumberInList(toList());
    }
}
