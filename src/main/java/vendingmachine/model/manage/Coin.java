package vendingmachine.model.coin;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private static final int STACK_COINS_BEGIN_VALUE = 0;
    private static final int COIN_STACK_UP_VOLUME = 1;

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    private int getAmount() {
        return this.amount;
    }

    private static List<Integer> toList() {
        return Arrays.stream(Coin.values()).map(Coin::getAmount)
            .collect(Collectors.toList());
    }

    private static Map<Integer, Integer> toMap() {
        Map<Integer, Integer> coins = new LinkedHashMap<>();

        for (Coin coin : values()) {
            coins.put(coin.amount, STACK_COINS_BEGIN_VALUE);
        }
        return coins;
    }

    public static Map<Integer, Integer> moneyToRandomCoins(int money) {
        Map<Integer, Integer> coins = toMap();

        while (money != 0) {
            int pickedCoin = createRandomCoin();
            if (money - pickedCoin < 0)
                continue;
            money -= pickedCoin;
            coins.put(pickedCoin, coins.get(pickedCoin) + COIN_STACK_UP_VOLUME);
        }
        return coins;
    }

    private static int createRandomCoin() {
        return Randoms.pickNumberInList(toList());
    }
}
