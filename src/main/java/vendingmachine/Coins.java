package vendingmachine;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class Coins {
    protected static final Integer ZERO = 0;
    protected static final Integer ONE = 1;
    protected static final String COIN_COUNT_UNIT = "개";
    protected static final String COIN_UNIT_AND_DASH = "원 - ";
    protected static final String TO_NEXT_LINE = "\r\n";

    protected final Map<Coin, Integer> coins = new HashMap<>();

    protected Coins() {
    }

    public Map<Coin, Integer> get() {
        return coins;
    }

    public boolean hasLessCoins(Coin coin, int coinCount) {
        return coins.get(coin) < coinCount;
    }

    public int getCoinCount(Coin coin) {
        return coins.get(coin);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        List<Coin> sortedCoins = sortCoinsReversed();

        sortedCoins.forEach(coin -> sb.append(coin.getAmount()).append(COIN_UNIT_AND_DASH)
                .append(coins.get(coin)).append(COIN_COUNT_UNIT)
                .append(TO_NEXT_LINE));

        return sb.toString();
    }

    public List<Coin> sortCoinsReversed() {
        return coins.keySet().stream()
                .sorted(Comparator.comparing(Coin::getAmount).reversed())
                .collect(Collectors.toList());
    }

    protected int getRestMoney(Integer totalAmount, int coinAmount, int coinCount) {
        return totalAmount - coinAmount * coinCount;
    }

    protected int getRestMoney(Integer totalAmount, int coinAmount) {
        return totalAmount - coinAmount;
    }

    protected boolean hasCoin(Coin coin) {
        return coins.get(coin) != ZERO && coins.get(coin) != null;
    }

}
