package vendingmachine.domain;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.Coin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static vendingmachine.Coin.*;

public class Change {
    private static final int FROM_100 = 1;
    private static final int FROM_50 = 2;
    private static final int FROM_10 = 3;
    private final List<Integer> coins = getCoins();
    private final Map<Coin, Integer> cash;

    Change(int amount) {
        this.cash = getInitCash();
        validateAmount(amount);
        createCoins(amount);
    }

    private void createCoins(int amount) {
        int current = amount;
        while (current > 0) {
            int pickNumber = getPickNumber(current);
            if (pickNumber <= current) {
                current -= pickNumber;
                cash.put(of(pickNumber), cash.get(of(pickNumber)) + 1);
            }
        }
    }

    private int getPickNumber(int number) {
        if (number > COIN_500.getAmount()) {
            return Randoms.pickNumberInList(coins);
        }
        if (number > COIN_100.getAmount()) {
            return Randoms.pickNumberInList(new ArrayList<>(coins.subList(FROM_100, coins.size())));
        }
        if (number > COIN_50.getAmount()) {
            return Randoms.pickNumberInList(new ArrayList<>(coins.subList(FROM_50, coins.size())));
        }

        return Randoms.pickNumberInList(new ArrayList<>(coins.subList(FROM_10, coins.size())));
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (Map.Entry<Coin, Integer> entry : cash.entrySet()) {
            Coin key = entry.getKey();
            Integer count = entry.getValue();
            totalPrice += key.getAmount() * count;
        }

        return totalPrice;
    }

    private void validateAmount(int amount) {
        if (isNotDivide10(amount)) {
            throw new IllegalArgumentException("[ERROR]");
        }

        if (isLessThan100(amount)) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    private boolean isLessThan100(int number) {
        return number < 100;
    }

    private boolean isNotDivide10(int number) {
        return number % 10 != 0;
    }

    public Map<Coin, Integer> getChange(int amount) {
        Map<Coin, Integer> cash = getStoredChange();
        Map<Coin, Integer> result = getInitCash();

        for (Map.Entry<Coin, Integer> entry : cash.entrySet()) {
            Coin key = entry.getKey();
            while (((amount / key.getAmount()) != 0) && (cash.get(key) > 0)) {
                amount -= key.getAmount();
                result.put(key, result.get(key) + 1);
                cash.put(key, cash.get(key) - 1);
            }
        }

        return result;
    }

    private HashMap<Coin, Integer> getInitCash() {
        return new HashMap<Coin, Integer>() {{
            for (Coin coin : Coin.values()) {
                put(coin, 0);
            }
        }};
    }

    public Map<Coin, Integer> getStoredChange() {
        return new HashMap<>(this.cash);
    }
}
