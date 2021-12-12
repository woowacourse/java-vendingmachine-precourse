package vendingmachine.domain;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import vendingmachine.Coin;

public class CashHolder {

    private static final String ERR_PREFIX = "[ERROR]";
    private static final String ERR_INVALID_TOTAL_AMOUNT = ERR_PREFIX + "금액음 10 단위로 나누어 떨어져야합니다.";
    private static final int MIN_VALUE = 10;
    private static final int EMPTY = 0;
    private final Map<Coin, Integer> coins;

    public CashHolder(int totalAmount) {
        validateTotalAmount(totalAmount);
        this.coins = fillChanges(totalAmount, new HashMap<>());
    }

    public void returnChanges(int amount) {
        Map<Coin, Integer> result = calculateChanges(amount, new HashMap<>());
        // TODO UI Logic print changes
    }

    private Map<Coin, Integer> calculateChanges(int amount, Map<Coin, Integer> changes) {
        Coin coin;

        if (coins.isEmpty() || amount == 0) {
            return changes;
        }
        try {
            coin = mostExpensiveCoinBelowAmount(amount);
            coins.computeIfPresent(coin, (k, v) -> v - 1);
            changes.putIfAbsent(coin, 0);
            changes.computeIfPresent(coin, (k, v) -> v + 1);
            amount -= coin.getAmount();
            return calculateChanges(amount, changes);
        } catch (IllegalArgumentException ignore) {
            return changes;
        }
    }

    private Coin mostExpensiveCoinBelowAmount(int amount) throws IllegalArgumentException {
        return this.coins.keySet().stream()
            .filter(c -> coins.get(c) != EMPTY)
            .filter(c -> c.getAmount() <= amount)
            .max(Comparator.comparingInt(Coin::getAmount))
            .orElseThrow(IllegalArgumentException::new);
    }

    private Map<Coin, Integer> fillChanges(int totalAmount, Map<Coin, Integer> coins) {
        Coin coin;
        if (totalAmount == 0) {
            return coins;
        }
        coin = Coin.getRandomCoinBelowAmount(totalAmount);
        coins.putIfAbsent(coin, 0);
        coins.computeIfPresent(coin, (k, v) -> v + 1);
        return fillChanges(totalAmount - coin.getAmount(), coins);
    }

    private void validateTotalAmount(int totalAmount) {
        if (totalAmount % MIN_VALUE != 0) {
            throw new IllegalArgumentException(ERR_INVALID_TOTAL_AMOUNT);
        }
    }
}
