package vendingmachine.domain;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.Coin;

import java.util.Collections;
import java.util.LinkedHashMap;
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
            return Randoms.pickNumberInList(Collections.unmodifiableList(coins.subList(FROM_100, coins.size())));
        }
        if (number > COIN_50.getAmount()) {
            return Randoms.pickNumberInList(Collections.unmodifiableList(coins.subList(FROM_50, coins.size())));
        }

        return Randoms.pickNumberInList(Collections.unmodifiableList(coins.subList(FROM_10, coins.size())));
    }

    private void validateAmount(int amount) {

        if (isNotDivide10(amount)) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    private boolean isNotDivide10(int number) {
        return number % 10 != 0;
    }

    public Map<Coin, Integer> getChange(int amount) {

        Map<Coin, Integer> storedChange = getStoredChange();
        Map<Coin, Integer> result = getInitCash();

        for (Map.Entry<Coin, Integer> entry : storedChange.entrySet()) {
            Coin key = entry.getKey();
            Integer count = storedChange.get(key);
            while (isPossibleReduceAmount(amount, count, key)) {
                amount -= key.getAmount();
                result.put(key, result.get(key) + 1);
                storedChange.put(key, storedChange.get(key) - 1);
            }
        }

        return result;
    }

    private boolean isPossibleReduceAmount(int amount, Integer count, Coin key) {
        return isPossibleDivide(amount, key) && isChangeRemain(count);
    }

    private boolean isChangeRemain(Integer count) {
        return count > 0;
    }

    private boolean isPossibleDivide(int amount, Coin key) {
        return (amount / key.getAmount()) != 0;
    }

    private LinkedHashMap<Coin, Integer> getInitCash() {

        return new LinkedHashMap<Coin, Integer>() {{
            for (Coin coin : Coin.values()) {
                put(coin, 0);
            }
        }};
    }

    public Map<Coin, Integer> getStoredChange() {
        return new LinkedHashMap<>(this.cash);
    }
}
