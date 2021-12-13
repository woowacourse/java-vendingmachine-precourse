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
        if (money % DIVISIBLE_VALUE != 0) {
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

    public Map<Coin, Integer> countWithMinimumCoins(int holdingAmount) {
        Map<Coin, Integer> changeMoney = new EnumMap<>(Coin.class);
        for (Coin coin : Coin.values()) {
            holdingAmount = getHoldingAmount(holdingAmount, changeMoney, coin);
        }
        return changeMoney;
    }

    private int getHoldingAmount(int holdingAmount, Map<Coin, Integer> changeMoney, Coin coin) {
        int amount = coin.getAmount();
        int quantity = coins.get(coin);
        int count = 0;
        while (holdingAmount > NONE) {
            if (amount <= holdingAmount && quantity > NONE) {
                holdingAmount -= amount;
                count += 1;
                quantity -= 1;
            }
            if (quantity <= NONE || amount > holdingAmount) {
                break;
            }
        }
        if (count != 0) {
            changeMoney.put(coin, count);
        }
        return holdingAmount;
    }

}
