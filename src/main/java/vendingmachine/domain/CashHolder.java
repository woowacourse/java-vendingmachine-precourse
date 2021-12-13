package vendingmachine.domain;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import vendingmachine.Coin;

public class CashHolder {

    private static final String ERR_PREFIX = "[ERROR]";
    private static final String ERR_BELOW_MIN_AMOUNT = ERR_PREFIX + "보유 금액은 0원 보다 커야 합니다.";
    private static final int MIN_AMOUNT = 10;
    private static final int ZERO = 0;
    private final Map<Coin, Integer> coins;

    public CashHolder(int totalAmount) {
        validatePositiveAmount(totalAmount);
        this.coins = fillChanges(totalAmount, new HashMap<>());
    }

    public Changes returnChanges(InputAmount inputAmount) {
        return new Changes(calculateChanges(inputAmount.getAmount(), new HashMap<>()));
    }

    public int getHoldingCoinCount(Coin coin) {
        return coins.getOrDefault(coin, ZERO);
    }

    private Map<Coin, Integer> calculateChanges(int amount, Map<Coin, Integer> changes) {
        Coin coin;

        if (amount < MIN_AMOUNT) {
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
            .filter(c -> coins.getOrDefault(c, ZERO) != ZERO)
            .filter(c -> c.getAmount() <= amount)
            .max(Comparator.comparingInt(Coin::getAmount))
            .orElseThrow(IllegalArgumentException::new);
    }

    private Map<Coin, Integer> fillChanges(int totalAmount, Map<Coin, Integer> coins) {
        Coin coin;

        if (totalAmount == ZERO) {
            return coins;
        }
        try {
            coin = Coin.getRandomCoinBelowAmount(totalAmount);
            coins.putIfAbsent(coin, ZERO);
            coins.computeIfPresent(coin, (k, v) -> v + 1);
            return fillChanges(totalAmount - coin.getAmount(), coins);
        } catch (IllegalArgumentException belowMinimumCoin) { // totalAmount < coin minimum amount
            return coins;
        }
    }

    private void validatePositiveAmount(int totalAmount) {
        if (totalAmount <= ZERO) {
            throw new IllegalArgumentException(ERR_BELOW_MIN_AMOUNT);
        }
    }
}
