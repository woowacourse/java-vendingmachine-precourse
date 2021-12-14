package vendingmachine;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public class Coins {
    private static final int DIVISIBLE_VALUE = 10;

    private static final int INITIAL_VALUE = 0;
    private static final int COUNTING_VALUE = 1;

    private static final int NONE = 0;

    private Map<Coin, Integer> coins;

    private Coins(final int money) {
        validateDivisible(money);
        validateNaturalNumber(money);
        initCoins();
        fullRandomAmount(money);
    }

    private void validateDivisible(int money) {
        if (money % DIVISIBLE_VALUE != NONE) {
            throw ErrorMessage.NOT_DIVISIBLE_VALUE.getException();
        }
    }

    private void validateNaturalNumber(int money) {
        if (money < NONE) {
            throw ErrorMessage.NOT_NATURAL_NUMBER.getException();
        }
    }

    private void initCoins() {
        coins = new EnumMap<>(Coin.class);
        Arrays.stream(Coin.values())
            .forEach(coin -> coins.put(coin, INITIAL_VALUE));
    }

    private void fullRandomAmount(int amount) {
        while (isNotUse(amount)) {
            int randomAmount = Coin.getRandomAmount();
            if (amount >= randomAmount) {
                Coin coin = Coin.findByAmount(randomAmount);
                coins.put(coin, countQuantity(coin));
                amount -= randomAmount;
            }
        }
    }

    private boolean isNotUse(int amount) {
        return amount > NONE;
    }

    private int countQuantity(Coin coin) {
        return coins.get(coin) + COUNTING_VALUE;
    }

    public static Coins createRandomCoins(final int money) {
        return new Coins(money);
    }

    public Map<Coin, Integer> getCoins() {
        return coins;
    }

    public int takeOut(Coin coin) {
        if (this.contains(coin)) {
            coins.put(coin, coins.get(coin) - 1);
            return coin.getAmount();
        }
        return NONE;
    }

    public boolean contains(Coin coin) {
        return coins.get(coin) > NONE;
    }
}
