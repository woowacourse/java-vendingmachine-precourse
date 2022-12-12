package vendingmachine.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

import static vendingmachine.utils.ErrorMessage.CHANGE_WRONG_VALUE;

public enum Coin {

    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    public static Coin of(int amount) {

        for (Coin coin : values()) {
            if (coin.amount == amount) {
                return coin;
            }
        }
        throw new IllegalArgumentException(CHANGE_WRONG_VALUE.getMessage());
    }

    public static int getRandomAmount(int number) {

        List<Integer> coins = getCoins();
        Coin[] values = values();

        for (int index = 0; index < values.length; index++) {
            Coin coin = values[index];
            if (number >= coin.getAmount()) {
                return Randoms.pickNumberInList(Collections.unmodifiableList(coins.subList(index, coins.size())));
            }
        }

        throw new IllegalArgumentException(CHANGE_WRONG_VALUE.getMessage());
    }

    public static Map<Coin, Integer> toEnumMap() {
        return new EnumMap<Coin, Integer>(Coin.class) {{
            Arrays.stream(Coin.values())
                    .forEach(coin -> put(coin, 0));
        }};
    }

    public int getAmount() {
        return this.amount;
    }

    public static List<Integer> getCoins() {

        return Arrays.stream(Coin.values())
                .map(Coin::getAmount)
                .collect(Collectors.toList());
    }

}
