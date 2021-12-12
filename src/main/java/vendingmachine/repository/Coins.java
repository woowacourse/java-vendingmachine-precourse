package vendingmachine.repository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.domain.Coin;

public class Coins {
    public static final int COIN_DEFAULT_COUNT = 0;
    public static final int SELECT_COIN_COUNT = 1;
    public static final int EMPTY_AMOUNT = 0;
    public static final int START_INDEX = 0;

    private final Map<Coin, Integer> coins = new TreeMap<>();

    public Coins(String value) {
        int amount = Integer.parseInt(value);
        do {
            int coinAmount = Randoms.pickNumberInList(makeList(amount));
            amount -= coinAmount;
            Coin coin = Coin.mapToCoin(coinAmount);
            coins.put(coin, coins.getOrDefault(coin, COIN_DEFAULT_COUNT) + SELECT_COIN_COUNT);
        } while (amount != EMPTY_AMOUNT);
    }

    private List<Integer> makeList(int amount) {
        if (Coin.COIN_500.isOrLess(amount)) {
            return Arrays.stream(Coin.values()).map(Coin::getAmount).collect(Collectors.toList());
        }
        if (Coin.COIN_100.isOrLess(amount)) {
            return Arrays.asList(Coin.COIN_100.getAmount(), Coin.COIN_50.getAmount(), Coin.COIN_10.getAmount());
        }
        if (Coin.COIN_50.isOrLess(amount)) {
            return Arrays.asList(Coin.COIN_50.getAmount(), Coin.COIN_10.getAmount());
        }
        return Collections.singletonList(Coin.COIN_10.getAmount());
    }

    public Map<Coin, Integer> getCoins() {
        return coins;
    }

    public Map<Coin, Integer> exchange(int amount) {
        Map<Coin, Integer> userCoins = new TreeMap<>();
        final int[] inputAmount = {amount};
        coins.forEach((coin, count) -> IntStream.range(START_INDEX, count).forEach(i -> {
            if (coin.isOrLess(inputAmount[START_INDEX])) {
                inputAmount[START_INDEX] -= coin.getAmount();
                userCoins.put(coin, userCoins.getOrDefault(coin, COIN_DEFAULT_COUNT) + SELECT_COIN_COUNT);
            }
        }));
        return userCoins;
    }
}
