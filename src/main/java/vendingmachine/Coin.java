package vendingmachine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import vendingmachine.message.ExceptionMessage;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);
    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    public static Coin getRandomCoin() {
        List<Integer> amountList = Arrays.stream(Coin.values())
                .map(coin -> coin.amount)
                .collect(Collectors.toList());
        int randomAmount = Randoms.pickNumberInList(amountList);
        return findByAmount(randomAmount);
    }

    private static Coin findByAmount(int amount) {
        return Arrays.stream(Coin.values())
                .filter(coin -> coin.amount == amount)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.INVALID_COIN));
    }

    public static List<Coin> getCoinOrderedList() {
        return Arrays.stream(Coin.values())
                .sorted((o1, o2) -> o2.amount - o1.amount)
                .collect(Collectors.toList());
    }

    public int getAmount() {
        return amount;
    }
}
