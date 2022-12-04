package vendingmachine.domain;

import vendingmachine.utils.Coin;

import java.util.LinkedHashMap;
import java.util.Map;

import static vendingmachine.utils.Coin.of;
import static vendingmachine.utils.MachineConst.MIN_CASH;

public class Change {

    private static final int FROM_100 = 1;
    private static final int FROM_50 = 2;
    private static final int FROM_10 = 3;
    private final Map<Coin, Integer> cash;

    Change(int amount) {

        this.cash = getInitCash();
        validateAmount(amount);
        createCoins(amount);
    }

    private LinkedHashMap<Coin, Integer> getInitCash() {

        return new LinkedHashMap<Coin, Integer>() {{
            for (Coin coin : Coin.values()) {
                put(coin, 0);
            }
        }};
    }

    private void validateAmount(int amount) {

        if (isNotDivideByMinCash(amount)) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    private boolean isNotDivideByMinCash(int number) {
        return number % MIN_CASH.get() != 0;
    }

    private void createCoins(int amount) {

        int current = amount;
        while (current > 0) {
            int pickNumber = Coin.getRandomAmount(current);
            current -= pickNumber;
            cash.put(of(pickNumber), cash.get(of(pickNumber)) + 1);
        }
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

    public Map<Coin, Integer> getStoredChange() {
        return new LinkedHashMap<>(this.cash);
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

}
