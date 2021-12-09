package vendingmachine;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.IntStream;

import camp.nextstep.edu.missionutils.Randoms;

public class Coins {
    private final Map<Coin, Integer> coins = new TreeMap<>();

    public Coins(String value) {
        int amount = Integer.parseInt(value);
        do {
            int coinAmount = Randoms.pickNumberInList(makeList(amount));
            amount -= coinAmount;
            Coin coin = Coin.mapCoin(coinAmount);
            coins.put(coin, coins.getOrDefault(coin, 0) + 1);
        } while (amount != 0);
    }

    private List<Integer> makeList(int amount) {
        if (amount >= 500) {
            return Arrays.asList(500, 100, 50, 10);
        }
        if (amount >= 100) {
            return Arrays.asList(100, 50, 10);
        }
        if (amount >= 50) {
            return Arrays.asList(50, 10);
        }
        return Collections.singletonList(10);
    }

    public Map getCoins() {
        return coins;
    }

    public Map exchange(InputAmount amount) {
        Map<Coin, Integer> userCoins = new TreeMap<>();
        final int[] inputAmount = {Integer.parseInt(amount.toString())};

        coins.forEach((coin, count) -> {
            for (int i = 0; i < count; i++) {
                if (!coin.isLessThan(inputAmount[0])) {
                    break;
                }
                if (coin.isLessThan(inputAmount[0])) {
                    inputAmount[0] -= coin.getAmount();
                    userCoins.put(coin, userCoins.getOrDefault(coin, 0) + 1);
                }
            }
        });
        return userCoins;
    }
}
