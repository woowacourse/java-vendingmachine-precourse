package vendingmachine;

import camp.nextstep.edu.missionutils.Randoms;
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
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 동전입니다."));
    }

    public int getAmount() {
        return amount;
    }
}
