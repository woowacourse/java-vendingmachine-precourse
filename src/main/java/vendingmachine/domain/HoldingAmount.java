package vendingmachine.domain;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import vendingmachine.Coin;

public class HoldingAmount {

    private static final String ERR_PREFIX = "[ERROR]";
    private static final String ERR_BELOW_MIN_AMOUNT = ERR_PREFIX + "보유 금액은 0원 보다 커야 합니다.";
    private static final int MIN_AMOUNT = 10;
    private static final int ZERO = 0;
    private final Map<Coin, Integer> coins;

    public HoldingAmount(int totalAmount) {
        validatePositiveAmount(totalAmount);
        this.coins = fillCoins(cutoffBelowMinAmount(totalAmount), new HashMap<>(),
            Coin::getRandomCoinBelowAmount);
    }

    public Changes returnChanges(InputAmount inputAmount) {
        return new Changes(
            fillCoins(cutoffBelowMinAmount(inputAmount.getAmount()),
                new HashMap<>(),
                this::popMostExpensiveCoinBelowAmount)
        );
    }

    public int getHoldingCoinCount(Coin coin) {
        return coins.getOrDefault(coin, ZERO);
    }

    private void validatePositiveAmount(int totalAmount) throws IllegalArgumentException {
        if (totalAmount <= ZERO) {
            throw new IllegalArgumentException(ERR_BELOW_MIN_AMOUNT);
        }
    }

    private Map<Coin, Integer> fillCoins(int amountAboveMinCoin, Map<Coin, Integer> target,
        Function<Integer, Coin> calculator) {
        if (amountAboveMinCoin == ZERO) {
            return target;
        }
        try {
            Coin coin = calculator.apply(amountAboveMinCoin);
            target.putIfAbsent(coin, ZERO);
            target.computeIfPresent(coin, (k, v) -> ++v);
            return fillCoins(amountAboveMinCoin - coin.getAmount(), target, calculator);
        } catch (IllegalArgumentException ignore) {
            return target;
        }
    }

    private Coin popMostExpensiveCoinBelowAmount(int amount) throws IllegalArgumentException {
        Coin coin = this.coins.keySet().stream()
            .filter(c -> coins.getOrDefault(c, ZERO) != ZERO)
            .filter(c -> c.isBelowAmount(amount))
            .max(Comparator.comparingInt(Coin::getAmount))
            .orElseThrow(IllegalArgumentException::new);
        this.coins.computeIfPresent(coin, (k, v) -> --v);
        return coin;
    }

    private int cutoffBelowMinAmount(int amount) {
        return amount - amount % MIN_AMOUNT;
    }
}
