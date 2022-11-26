package vendingmachine.domain;

import java.util.EnumMap;
import vendingmachine.CoinMaker;

public class RemainingCoins {
    private final Money money;
    private EnumMap<Coin, Integer> remainingCoins;

    public RemainingCoins(String input) {
        money = new Money(input);
        remainingCoins = CoinMaker.generateCoins(money);
    }

    public Money getMoney() {
        return money;
    }

    public EnumMap<Coin, Integer> getRemainingCoins() {
        return remainingCoins;
    }

    // greedy !!
    public EnumMap<Coin, Integer> giveChange(int usersMoney) {
        EnumMap<Coin, Integer> change = new EnumMap<>(Coin.class);
        for (Coin coin : remainingCoins.keySet()){
            int count = 0;
            while (remainingCoins.get(coin) > 0 && usersMoney >= coin.amount()){
                remainingCoins.put(coin, remainingCoins.get(coin) - 1);
                usersMoney -= coin.amount();
                change.put(coin, count++);
            }
        }
        return change;
    }
}
