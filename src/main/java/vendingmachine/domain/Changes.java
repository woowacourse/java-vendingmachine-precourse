package vendingmachine.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Changes {

    private final List<Integer> coinAmounts = Collections.unmodifiableList(Coin.amounts());
    private final Map<Coin, Integer> coins;

    public Changes(int seedMoney) {
        coins = generateRandomCoins(seedMoney);
    }

    private Map<Coin, Integer> generateRandomCoins(int seedMoney) {
        Map<Coin, Integer> coins = initCoinCountMap();

        while (seedMoney >= Coin.COIN_10.getAmount()) {
            int randomAmount = Randoms.pickNumberInList(coinAmounts);
            Coin matchedCoin = Coin.getCoinWithValue(randomAmount);
            if (isPossibleToAdd(seedMoney, randomAmount)) {
                coins.put(matchedCoin, coins.get(matchedCoin) + 1);
                seedMoney -= randomAmount;
            }
        }
        return coins;
    }

    private boolean isPossibleToAdd(int seedMoney, int randomAmount) {
        return seedMoney >= randomAmount;
    }

    private Map<Coin, Integer> initCoinCountMap() {
        Map<Coin, Integer> result = new HashMap<>();
        for (Coin coin : Coin.values()) {
            result.put(coin, 0);
        }
        return result;
    }

    public int sum() {
        int sum = 0;
        for (Map.Entry<Coin, Integer> entry : coins.entrySet()) {
            sum += entry.getKey().getAmount() * entry.getValue();
        }
        return sum;
    }
}
