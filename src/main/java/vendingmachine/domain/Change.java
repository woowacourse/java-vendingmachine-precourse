package vendingmachine.domain;

import vendingmachine.utils.Coin;

import java.util.EnumMap;
import java.util.Map;

import static vendingmachine.utils.ErrorMessage.CHANGE_WRONG_VALUE;
import static vendingmachine.utils.MachineConst.MIN_CASH;

public class Change {

    private static final int FROM_100 = 1;
    private static final int FROM_50 = 2;
    private static final int FROM_10 = 3;
    private final Map<Coin, Integer> cash;

    Change(int amount) {
        this.cash = Coin.toEnumMap();
        validateAmount(amount);
        createCoins(amount);
    }

    private void validateAmount(int amount) {

        if (isNotDivideByMinCash(amount)) {
            throw new IllegalArgumentException(CHANGE_WRONG_VALUE.getMessage());
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
            cash.put(Coin.of(pickNumber), cash.get(Coin.of(pickNumber)) + 1);
        }
    }

    public Map<Coin, Integer> getChange(int amount) {

        Map<Coin, Integer> storedChange = this.cash;
        Map<Coin, Integer> result = Coin.toEnumMap();

        for (Map.Entry<Coin, Integer> entry : storedChange.entrySet()) {
            Coin coin = entry.getKey();

            while (isPossibleReduceAmount(amount, storedChange.get(coin), coin)) {
                amount -= coin.getAmount();
                result.put(coin, result.get(coin) + 1);
                storedChange.put(coin, storedChange.get(coin) - 1);
            }
        }

        return result;
    }

    public Map<Coin, Integer> getStoredChange() {
        return new EnumMap<Coin, Integer>(this.cash);
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
